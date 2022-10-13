(ns string-calculator-clj._06.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn split-and-convert-to-integers [numbers]
  (letfn [(split-on-default-delimiter [numbers] (str/split numbers #"[,\n]"))
          (convert-to-integers [numbers] (map #(Integer/parseInt %) numbers))]
    (convert-to-integers (split-on-default-delimiter numbers))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert-to-integers numbers))))