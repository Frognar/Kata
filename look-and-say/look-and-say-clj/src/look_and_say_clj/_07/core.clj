(ns look-and-say-clj._07.core
  (:require [clojure.string :as str]))

(defn say [count input] (str count input))

(defn look-and-say [input]
  (loop [count 1
         [current & input] input
         result []]
    (if (not (nil? input))
      (if (= current (first input))
        (recur (inc count) input result)
        (str count current count (first input)))
      (str/join (conj result (say count current))))))
