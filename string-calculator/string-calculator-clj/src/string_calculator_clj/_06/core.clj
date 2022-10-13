(ns string-calculator-clj._06.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn convert-to-integers [numbers]
  (map #(Integer/parseInt %) numbers))

(defn split-numbers-separated-by-comma [numbers]
  (str/split numbers #","))

(defn split-and-convert-to-integers [numbers]
  (convert-to-integers (split-numbers-separated-by-comma numbers)))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert-to-integers numbers))))