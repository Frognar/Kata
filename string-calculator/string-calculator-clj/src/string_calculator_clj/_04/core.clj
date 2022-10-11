(ns string-calculator-clj._04.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (map #(Integer/parseInt %) (str/split numbers #",")))

(defn sum-of [numbers] (reduce + numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert numbers)]
      (sum-of numbers))))