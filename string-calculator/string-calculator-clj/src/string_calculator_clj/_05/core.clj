(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn split-and-convert [numbers]
  (let [delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers delimiters))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert numbers)]
      (if (some #(< % 0) numbers) (throw IllegalArgumentException))
      (sum-of numbers))))