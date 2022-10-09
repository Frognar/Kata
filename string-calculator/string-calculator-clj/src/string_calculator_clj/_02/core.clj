(ns string-calculator-clj._02.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (let [less-than-or-equal-to-thousand (filter #(<= % 1000) numbers)]
    (reduce + less-than-or-equal-to-thousand)))

(defn assert-none-negative-values [numbers]
  (if (some #(< % 0) numbers)
    (throw (new IllegalArgumentException "Negative values not allowed"))))

(defn split-and-convert [numbers]
  (let [default-delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers default-delimiters))))

(defn get-list-of-sorted-delimiters [delimiters-group]
  (sort-by count #(compare %2 %1) (str/split delimiters-group #"\Q][\E")))

(defn find-all-delimiters [match]
  (if (nil? (second match))
    (re-pattern (str/join "|" (get-list-of-sorted-delimiters (nth match 2))))
    (second match)))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [matcher (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers)
        match (re-find matcher)]
    (if (nil? match)
      numbers
      (let [delimiter (find-all-delimiters match)
            numbers (subs numbers (count (first match)))]
        (str/replace numbers delimiter ",")))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers-separated-by-comma (replace-custom-delimiter-with-comma numbers)
          numbers (split-and-convert numbers-separated-by-comma)]
      (assert-none-negative-values numbers)
      (sum-of numbers))))
