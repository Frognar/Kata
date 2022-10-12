(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
    (if contains-negative? (throw IllegalArgumentException))))

(defn replace-custom-delimiter-with-comma [numbers]
  (if (not (str/starts-with? numbers "//"))
    numbers
    (str/replace (subs numbers 4) (str (nth numbers 2)) ",")))

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