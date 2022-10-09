(ns string-calculator-clj._02.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (map #(Integer/parseInt %) (str/split numbers #"[,\n]")))

(defn sum-of [numbers]
  (reduce + numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert numbers))))
