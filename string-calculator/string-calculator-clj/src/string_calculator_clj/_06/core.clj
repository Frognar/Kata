(ns string-calculator-clj._06.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn convert-to-integers [numbers]
  (map #(Integer/parseInt %) numbers))

(defn split-numbers-separated-by-comma [numbers]
  (str/split numbers #","))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (convert-to-integers (split-numbers-separated-by-comma numbers)))))