(ns string-calculator-clj._03.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn split-and-convert [numbers]
  (let [numbers (str/split numbers #"[,\n]")]
    (map #(Integer/parseInt %) numbers)))

(defn replace-custom-delimiter-with-comma [numbers]
  (if (str/starts-with? numbers "//")
    (str/replace (subs numbers 4) (str (nth numbers 2)) ",")
    numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert (replace-custom-delimiter-with-comma numbers))]
      (sum-of numbers))))
