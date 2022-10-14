(ns string-calculator-clj._07.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn convert-to-integer [number] (Integer/parseInt number))

(defn split-on-comma [numbers] (str/split numbers #","))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (map #(convert-to-integer %) (split-on-comma numbers)))))
