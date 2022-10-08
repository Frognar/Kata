(ns string-calculator-clj._01.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (let [number_list (str/split numbers #"[,\n]")]
    (map #(Integer/parseInt %) number_list)))

(defn sum-of [numbers]
  (reduce + numbers))

(defn replace-custom-delimiter-with-comma [numbers]
  (if (str/starts-with? numbers "//")
    (let [comma ","
          delimiter (str (nth numbers 2))
          rest_numbers (subs numbers 4)]
      (str/replace rest_numbers delimiter comma))
    numbers))

(defn add [numbers]
  (if (or (nil? numbers) (empty? numbers))
    0
    (sum-of (split-and-convert (replace-custom-delimiter-with-comma numbers))))
  )
