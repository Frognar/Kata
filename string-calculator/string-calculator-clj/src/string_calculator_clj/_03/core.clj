(ns string-calculator-clj._03.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (str/split numbers #",")]
      (sum-of (map #(Integer/parseInt %) numbers)))))
