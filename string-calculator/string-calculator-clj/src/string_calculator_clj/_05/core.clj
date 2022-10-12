(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
    (if contains-negative? (throw IllegalArgumentException))))

(defn find-delimiter [match]
  (if (nil? (first match))
    (second match)
    (first match)))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [[delimiter-prefix & match] (re-find (re-matcher #"//(.)\n|//\Q[\E(.)]\n" numbers))
        size-of-prefix (count delimiter-prefix)
        numbers-without-prefix (subs numbers size-of-prefix)
        delimiter (find-delimiter match)]
    (if (nil? match)
      numbers
      (str/replace numbers-without-prefix delimiter ","))))

(defn split-and-convert [numbers]
  (let [numbers (replace-custom-delimiter-with-comma numbers)
        delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers delimiters))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert numbers)]
      (assert-none-negative-values numbers)
      (sum-of numbers))))