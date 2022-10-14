(ns string-calculator-clj._07.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn split-and-convert-to-integers [numbers]
  (letfn [(split-on-comma [n] (str/split n #","))
          (convert-to-integer [n] (Integer/parseInt n))]
    (map #(convert-to-integer %) (split-on-comma numbers))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert-to-integers numbers)]
      (sum-of numbers))))
