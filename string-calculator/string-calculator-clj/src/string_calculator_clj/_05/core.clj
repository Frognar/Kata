(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn filter-less-than-or-equal-to-thousand [numbers]
  (filter #(<= % 1000) numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
    (if contains-negative? (throw IllegalArgumentException))))

(defn get-sorted-delimiters-form [multi-delimiter-match]
  (reverse (sort-by count (str/split multi-delimiter-match #"]\Q[\E"))))

(defn find-delimiters [[single-delimiter-match multi-delimiter-match & _]]
  (if (nil? single-delimiter-match)
    (re-pattern (str/join "|" (get-sorted-delimiters-form multi-delimiter-match)))
    single-delimiter-match))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [[delimiter-prefix & match] (re-find (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers))]
    (if (nil? match)
      numbers
      (let [size-of-prefix (count delimiter-prefix)
            numbers-without-prefix (subs numbers size-of-prefix)
            delimiter (find-delimiters match)]
        (str/replace numbers-without-prefix delimiter ",")))))

(defn split-and-convert [numbers]
  (let [numbers (replace-custom-delimiter-with-comma numbers)
        delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers delimiters))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert numbers)]
      (assert-none-negative-values numbers)
      (sum-of (filter-less-than-or-equal-to-thousand numbers)))))