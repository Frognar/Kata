(ns string-calculator-clj._07.core
  (:require [clojure.string :as str])
  (:import (java.util.regex Pattern)))

(defn sum-of [numbers] (reduce + numbers))

(defn filter-less-than-or-equal-to-thousand [numbers]
  (filter #(<= % 1000) numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
   (if contains-negative? (throw IllegalArgumentException))))

(defn get-delimiters-from [multi-delimiters]
  (reverse (map #(Pattern/quote %) (sort-by count (str/split multi-delimiters #"]\Q[\E")))))

(defn find-delimiters [[single-delimiter multi-delimiters & _]]
  (if (nil? single-delimiter)
    (re-pattern (str/join "|" (get-delimiters-from multi-delimiters)))
    single-delimiter))

(defn replace-delimiters-with-comma [delimiter-group numbers]
  (let [delimiter (find-delimiters delimiter-group)]
    (str/replace numbers delimiter ",")))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [[delimiter-prefix & delimiters-group] (re-find (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers))
        numbers-without-prefix (subs numbers (count delimiter-prefix))]
    (if (nil? delimiters-group)
      numbers
      (replace-delimiters-with-comma delimiters-group numbers-without-prefix))))

(defn split-and-convert-to-integers [numbers]
  (let [numbers (replace-custom-delimiter-with-comma numbers)]
    (letfn [(split-on-default-delimiter [n] (str/split n #"[,\n]"))
            (convert-to-integer [n] (Integer/parseInt n))]
      (map #(convert-to-integer %) (split-on-default-delimiter numbers)))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert-to-integers numbers)]
      (assert-none-negative-values numbers)
      (sum-of (filter-less-than-or-equal-to-thousand numbers)))))
