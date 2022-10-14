(ns string-calculator-clj._07.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn convert-to-integer [number] (Integer/parseInt number))

(defn split-and-convert-to-integers [numbers]
  (letfn [(split-on-comma [n] (str/split n #","))]
    (map #(convert-to-integer %) (split-on-comma numbers))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert-to-integers numbers))))
