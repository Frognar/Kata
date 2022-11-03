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
  (let [result [start]]
    (if (= depth 1)
      (str/join ";" (conj result (look-and-say start)))
      (str/join ";" result))))