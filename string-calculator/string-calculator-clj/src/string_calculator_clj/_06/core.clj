(ns string-calculator-clj._06.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn filter-less-than-or-equal-to-million [numbers]
  (filter #(<= % 1000000) numbers))

(defn assert-none-negative-values-in [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
    (if contains-negative? (throw IllegalArgumentException))))

(defn get-delimiters-from [multi-delimiter-match]
  (reverse (sort-by count (str/split multi-delimiter-match #"]\Q[\E"))))

(defn find-delimiters [[single-delimiter-match multi-delimiter-match & _]]
  (if (nil? single-delimiter-match)
    (re-pattern (str/join "|" (get-delimiters-from multi-delimiter-match)))
    single-delimiter-match))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [[delimiter-prefix & match] (re-find (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers))]
    (if (nil? match)
      numbers
      (let [size-of-prefix (count delimiter-prefix)
            numbers-without-prefix (subs numbers size-of-prefix)
            delimiter (find-delimiters match)]
        (str/replace numbers-without-prefix delimiter ",")))))

(defn split-and-convert-to-integers [numbers]
  (let [default-delimiters #"[,\n]"
        numbers (replace-custom-delimiter-with-comma numbers)]
    (letfn [(split-on-default-delimiter [numbers] (str/split numbers default-delimiters))
            (convert-to-integers [numbers] (map #(Integer/parseInt %) numbers))]
      (convert-to-integers (split-on-default-delimiter numbers)))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert-to-integers numbers)]
      (assert-none-negative-values-in numbers)
      (sum-of (filter-less-than-or-equal-to-million numbers)))))