(ns string-calculator-clj._02.core
  (:require [clojure.string :as str]))

(defn find-all-delimiters [match]
  (if (nil? (second match))
    (re-pattern (str/join "|" (str/split (nth match 2) #"\Q][\E")))
    (second match)))

(defn replace-custom-delimiter-with-comma [numbers]
  (let [matcher (re-matcher #"//(.)\n|//\Q[\E(.+)]\n" numbers)
        match (re-find matcher)]
    (if (nil? match)
      numbers
      (let [delimiter (find-all-delimiters match)
            numbers (subs numbers (count (first match)))]
        (str/replace numbers delimiter ",")))))

(defn split-and-convert [numbers]
  (let [default-delimiters #"[,\n]"]
    (map #(Integer/parseInt %) (str/split numbers default-delimiters))))

(defn sum-of [numbers]
  (reduce + numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (sum-of (split-and-convert (replace-custom-delimiter-with-comma numbers)))))
