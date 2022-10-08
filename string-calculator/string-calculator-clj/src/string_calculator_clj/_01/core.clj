(ns string-calculator-clj._01.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (map #(Integer/parseInt %)
       (str/split numbers #",")))

(defn sum-of [numbers]
  (reduce + numbers))

(defn add [numbers]
  (if (or (nil? numbers) (empty? numbers))
    0
      (sum-of (split-and-convert numbers)))
    )
