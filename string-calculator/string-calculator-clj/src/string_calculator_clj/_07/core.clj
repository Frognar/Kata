(ns string-calculator-clj._07.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn filter-less-than-or-equal-to-thousand [numbers]
  (filter #(<= % 1000) numbers))

(defn assert-none-negative-values [numbers]
  (let [contains-negative? (some #(< % 0) numbers)]
   (if contains-negative? (throw IllegalArgumentException))))

(defn replace-delimiters-with-comma [delimiters-group numbers]
  (let [delimiter (first delimiters-group)]
    (str/replace numbers delimiter ",")))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [[delimiter-prefix & match] (re-find (re-matcher #"//(.)\n" numbers))]
    (if (nil? match)
      numbers
      (replace-delimiters-with-comma match (subs numbers (count delimiter-prefix))))))

(defn split-and-convert-to-integers [numbers]
  (let [numbers (replace-custom-delimiter-with-comma numbers)]
    (letfn [(split-on-default-delimiter [n] (str/split n #"[,\n]"))
            (convert-to-integer [n] (Integer/parseInt n))]
      (map #(convert-to-integer %) (split-on-default-delimiter numbers)))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert-to-integers numbers)]
      (assert-none-negative-values numbers)
      (sum-of (filter-less-than-or-equal-to-thousand numbers)))))
