(ns look-and-say-clj._05.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (loop [result []
         count 1
         [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result (inc count) input)
        (recur (conj result (str count current)) count input))
      (str/join (conj result (str count current))))))
