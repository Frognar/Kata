(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn assert-none-negative-values [numbers]
  (if (some #(< % 0) numbers) (throw IllegalArgumentException)))

(defn split-and-convert [numbers]
  (let [delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers delimiters))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert numbers)]
      (assert-none-negative-values numbers)
      (sum-of numbers))))