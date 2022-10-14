(ns string-calculator-clj._07.core
  (:require [clojure.string :as str]))

(defn convert-to-integer [number] (Integer/parseInt number))

(defn split-on-comma [numbers] (str/split numbers #","))

(defn add [numbers]
  (if (empty? numbers)
    0
    (reduce + (map #(convert-to-integer %) (split-on-comma numbers)))))
