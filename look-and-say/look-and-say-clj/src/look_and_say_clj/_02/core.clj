(ns look-and-say-clj._02.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (loop [result []
        [current & input] input
        dig_count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur result input (inc dig_count))
        (str/join (conj result (str dig_count current dig_count (first input)))))
      (str/join (conj result (str dig_count current))))))
