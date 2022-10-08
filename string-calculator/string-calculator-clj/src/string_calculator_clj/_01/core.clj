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
          matcher (re-matcher #"//(.)\n|//\[(.+)]\n" numbers)
          match (re-find matcher)
          delimiter (if (nil? (second match)) (nth match 2) (second match))
          rest_numbers (subs numbers (count (first match)))]
      (print delimiter)
      (str/replace rest_numbers delimiter comma))
    numbers))

(defn add [numbers]
  (if (or (nil? numbers) (empty? numbers))
    0
    (sum-of (split-and-convert (replace-custom-delimiter-with-comma numbers))))
  )
