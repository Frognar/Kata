(ns look-and-say-clj._03.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (loop [result []
         [current & input] input
         digit_count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result input (inc digit_count))
        (recur (conj result (str digit_count current)) input digit_count))
      (str/join (conj result (str digit_count current))))))