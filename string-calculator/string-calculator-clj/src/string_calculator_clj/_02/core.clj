(ns string-calculator-clj._02.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (let [default-delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers default-delimiters))))

(defn sum-of [numbers]
  (reduce + numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (if (str/starts-with? numbers "//")
                    (str/replace (subs numbers 4 (count numbers)) (str (nth numbers 2)), ",")
                    numbers)]
      (sum-of (split-and-convert numbers)))))
