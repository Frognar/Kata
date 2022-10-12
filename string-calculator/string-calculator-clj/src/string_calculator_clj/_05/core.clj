(ns string-calculator-clj._05.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (map #(Integer/parseInt %) (str/split numbers #",")))

(defn add [numbers]
  (if (empty? numbers)
    0
    (reduce + (split-and-convert numbers))))