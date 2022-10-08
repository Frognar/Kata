(ns string-calculator-clj._01.core
  (:require [clojure.string :as str]))

(defn split-and-convert [numbers]
  (let [number_list (str/split numbers #"[,\n]")]
    (map #(Integer/parseInt %) number_list)))

(defn sum-of [numbers]
  (reduce + numbers))

(defn get-all-custom-delimiters [match]
  (if (nil? (second match))
    (re-pattern (str/join #"|" (sort-by count #(compare %2 %1) (str/split (nth match 2) #"\Q][\E"))))
    (second match)))

(defn replace-all-custom-delimiters-with-comma [numbers match]
  (let [[numbers custom_delimiter] [(subs numbers (count (first match))) (get-all-custom-delimiters match)]]
    (str/replace numbers custom_delimiter ",")))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [custom-delimiter-pattern #"//(.)\n|//\[(.+)]\n"
        matcher (re-matcher custom-delimiter-pattern numbers)
        match (re-find matcher)]
    (if (nil? match)
      numbers
      (replace-all-custom-delimiters-with-comma numbers match))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert (replace-custom-delimiter-with-comma numbers)))))
