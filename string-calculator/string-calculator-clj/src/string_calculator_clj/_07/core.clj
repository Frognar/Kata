(ns string-calculator-clj._07.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
   (if contains-negative? (throw IllegalArgumentException))))

(defn split-and-convert-to-integers [numbers]
  (letfn [(split-on-default-delimiter [n] (str/split n #"[,\n]"))
          (convert-to-integer [n] (Integer/parseInt n))]
    (map #(convert-to-integer %) (split-on-default-delimiter numbers))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert-to-integers numbers)]
      (assert-none-negative-values numbers)
      (sum-of (filter #(<= % 1000) numbers)))))
