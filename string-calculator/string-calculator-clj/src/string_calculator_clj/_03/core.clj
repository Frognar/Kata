(ns string-calculator-clj._03.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + (filter #(<= % 1000) numbers)))

(defn split-and-convert [numbers]
  (let [numbers (str/split numbers #"[,\n]")]
    (map #(Integer/parseInt %) numbers)))

(defn get-list-of-sorted-delimiters [delimiter-group]
  (reverse (sort-by count (str/split delimiter-group #"]\Q[\E"))))

(defn find-all-delimiters [match]
  (if (nil? (second match))
    (re-pattern (str/join "|" (get-list-of-sorted-delimiters (nth match 2))))
    (second match)))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [matcher (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers)
        match (re-find matcher)]
    (if (nil? match)
      numbers
      (let [delimiter (find-all-delimiters match)
            numbers (subs numbers (count (first match)))]
        (str/replace numbers delimiter ",")))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert (replace-custom-delimiter-with-comma numbers))]
      (sum-of numbers))))
