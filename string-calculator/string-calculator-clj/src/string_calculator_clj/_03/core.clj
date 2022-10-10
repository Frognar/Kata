(ns string-calculator-clj._03.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn split [numbers]
  (str/split numbers #","))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split numbers)]
      (sum-of (map #(Integer/parseInt %) numbers)))))
