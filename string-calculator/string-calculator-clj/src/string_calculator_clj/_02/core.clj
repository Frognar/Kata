(ns string-calculator-clj._02.core
  (:require [clojure.string :as str]))

(defn replace-custom-delimiter-with-comma [numbers]
  (if (str/starts-with? numbers "//")
    (str/replace (subs numbers 4 (count numbers)) (str (nth numbers 2)), ",")
    numbers))

(defn split-and-convert [numbers]
  (let [default-delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers default-delimiters))))

(defn sum-of [numbers]
  (reduce + numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert (replace-custom-delimiter-with-comma numbers)))))
