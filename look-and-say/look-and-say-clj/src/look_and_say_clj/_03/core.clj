(ns look-and-say-clj._03.core
  (:require [clojure.string :as str]))

(defn say [count digit] (str count digit))

(defn look-and-say [input]
  (loop [result []
         [current & input] input
         digit_count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result input (inc digit_count))
        (recur (conj result (say digit_count current)) input 1))
      (str/join (conj result (say digit_count current))))))

(defn look-and-say-sequence [start depth]
  (let [result [start]
        current start]
    (if (= depth 1)
      (let [current (look-and-say current)]
        (str/join ":" (conj result current)))
      (str/join ":" result))))
