(ns string-calculator-clj._06.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn assert-none-negative-values-in [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
    (if contains-negative? (throw IllegalArgumentException))))

(defn replace-custom-delimiter-with-comma [numbers]
  (if (not (str/starts-with? numbers "//"))
    numbers
    (str/replace (subs numbers 4) (str (nth numbers 2)) ",")))

(defn split-and-convert-to-integers [numbers]
  (let [default-delimiters #"[,\n]"
        numbers (replace-custom-delimiter-with-comma numbers)]
    (letfn [(split-on-default-delimiter [numbers] (str/split numbers default-delimiters))
            (convert-to-integers [numbers] (map #(Integer/parseInt %) numbers))]
      (convert-to-integers (split-on-default-delimiter numbers)))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert-to-integers numbers)]
      (assert-none-negative-values-in numbers)
      (sum-of numbers))))