(ns string-calculator-clj._04.core
  (:require [clojure.string :as str]))

(defn sum-of [numbers] (reduce + numbers))

(defn contains-negative? [numbers] (some #(< % 0) numbers))

(defn assert-none-negative-values [numbers]
  (if (contains-negative? numbers) (throw IllegalArgumentException)))

(defn split-and-convert [numbers]
  (map #(Integer/parseInt %) (str/split numbers #"[,\n]")))

(defn get-sorted-delimiters [delimiter-group]
  (reverse (sort-by count (str/split (nth delimiter-group 2) #"]\Q[\E"))))

(defn find-custom-delimiters [delimiter-group]
  (if (nil? (second delimiter-group))
    (re-pattern (str/join "|" (get-sorted-delimiters delimiter-group)))
    (second delimiter-group)))

(defn replace-custom-delimiters-with-comma [numbers]
  (let [match (re-find (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers))]
    (if (nil? match)
      numbers
      (let [delimiters (find-custom-delimiters match)
            only-numbers (subs numbers (count (first match)))]
        (str/replace only-numbers delimiters ",")))))

(defn add [numbers]
  (if (empty? numbers)
    0
    (let [numbers (split-and-convert (replace-custom-delimiters-with-comma numbers))]
      (assert-none-negative-values numbers)
      (sum-of (filter #(<= % 1000) numbers)))))