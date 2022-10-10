(ns string-calculator-clj._03.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers]
  (reduce + numbers))

(defn split-and-convert [numbers]
  (let [numbers (str/split numbers #"[,\n]")]
    (map #(Integer/parseInt %) numbers)))

(defn get-list-of-sorted-delimiters [match]
  (sort-by count #(compare %2 %1) (str/split (nth match 2) #"]\Q[\E")))

(defn find-all-delimiters [match]
  (if (nil? (second match))
    (re-pattern (str/join "|" (get-list-of-sorted-delimiters match)))
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
