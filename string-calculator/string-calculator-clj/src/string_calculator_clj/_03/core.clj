(ns string-calculator-clj._03.core
  (:require [clojure.string :as str]))

(defn add [numbers]
  (if (empty? numbers)
    0
    (reduce + (map #(Integer/parseInt %) (str/split numbers #",")))))
