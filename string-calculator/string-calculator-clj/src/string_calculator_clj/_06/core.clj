(ns string-calculator-clj._06.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn split-numbers-separated-by-comma [numbers]
  (str/split numbers #","))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (map #(Integer/parseInt %) (split-numbers-separated-by-comma numbers)))))