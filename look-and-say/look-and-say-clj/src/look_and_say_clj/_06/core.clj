(ns look-and-say-clj._06.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (loop [result []
         count 1
         [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result (inc count) input)
        (str count current count (first input)))
      (str/join (conj result (str count current))))))
