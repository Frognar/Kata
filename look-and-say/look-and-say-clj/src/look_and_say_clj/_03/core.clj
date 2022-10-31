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
  (loop [result [start]
         current start
         depth depth]
    (if (> depth 0)
      (let [current (look-and-say current)]
        (recur (conj result current) current (dec depth)))
      (str/join ":" result))))
