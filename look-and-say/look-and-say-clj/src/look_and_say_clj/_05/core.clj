(ns look-and-say-clj._05.core
  (:require [clojure.string :as str]))

(defn say [count input] (str count input))

(defn look-and-say [input]
  (loop [result []
         count 1
         [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result (inc count) input)
        (recur (conj result (say count current)) 1 input))
      (str/join (conj result (say count current))))))
