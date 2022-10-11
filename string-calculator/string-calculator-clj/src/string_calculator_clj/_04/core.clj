(ns string-calculator-clj._04.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn contains-negative? [numbers] (some #(< % 0) numbers))

(defn assert-none-negative-values [numbers]
  (if (contains-negative? numbers) (throw IllegalArgumentException)))

(defn split-and-convert [numbers]
  (map #(Integer/parseInt %) (str/split numbers #"[,\n]")))

(defn replace-custom-delimiters-with-comma [numbers]
  (if (str/starts-with? numbers "//")
    (str/replace (subs numbers 4) (str (nth numbers 2)) ",")
    numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert (replace-custom-delimiters-with-comma numbers))]
      (assert-none-negative-values numbers)
      (sum-of numbers))))