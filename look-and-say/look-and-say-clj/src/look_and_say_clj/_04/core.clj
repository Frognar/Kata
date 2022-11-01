(ns look-and-say-clj._04.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (loop [result []
         [current & input] input
          count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result input (inc count))
        (str count current count (first input)))
      (str/join (conj result (str count current))))))
