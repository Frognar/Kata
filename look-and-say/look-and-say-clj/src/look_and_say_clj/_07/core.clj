(ns look-and-say-clj._07.core
  (:require [clojure.string :as str]))

(defn say [count input] (str count input))

(defn look-and-say [input]
  (loop [count 1
         [current & input] input
         result []]
    (if (not (nil? input))
      (if (= current (first input))
        (say (inc count) current)
        (str count current count (first input)))
      (str/join (conj result (say count current))))))
