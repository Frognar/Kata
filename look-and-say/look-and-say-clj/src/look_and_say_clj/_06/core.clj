(ns look-and-say-clj._06.core
  (:require [clojure.string :as str]))

(defn say [count digit] (str count digit))

(defn look-and-say [input]
  (loop [result []
         count 1
         [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result (inc count) input)
        (recur (conj result (say count current)) 1 input))
      (str/join (conj result (say count current))))))

(defn look-and-say-sequence [start depth]
  (loop [result [start]
         current start
         depth depth]
    (if (> depth 0)
      (let [current (look-and-say current)]
        (recur (conj result current) current (dec depth)))
      (str/join ";" result))))