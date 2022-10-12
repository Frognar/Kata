(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
    (if contains-negative? (throw IllegalArgumentException))))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [[delimiter-prefix & match] (re-find (re-matcher #"//(.)\n" numbers))
        size-of-prefix (count delimiter-prefix)]
    (if (nil? match)
      numbers
      (str/replace (subs numbers size-of-prefix) (first match) ","))))

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