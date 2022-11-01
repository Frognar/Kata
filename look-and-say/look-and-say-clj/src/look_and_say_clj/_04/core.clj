(ns look-and-say-clj._04.core
  (:require [clojure.string :as str]))

(defn say [count digit] (str count digit))

(defn look-and-say [input]
  (loop [result []
         [current & input] input
         count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result input (inc count))
        (recur (conj result (say count current)) input 1))
      (str/join (conj result (say count current))))))

(defn look-and-say-sequence [input depth]
  (loop [result [input]
         current input
         depth depth]
    (if (> depth 0)
      (let [current (look-and-say current)]
        (recur (conj result current) current (dec depth)))
      (str/join "-" result))))