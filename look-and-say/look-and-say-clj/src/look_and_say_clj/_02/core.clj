(ns look-and-say-clj._02.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (let [result []
        dig_count 1]
    (if (= (count input) 2)
      (if (= (first input) (second input))
        (str/join (conj result (str (inc dig_count) (first input))))
        (str/join (conj result (str dig_count (first input) dig_count (second input)))))
      (str/join (conj result (str dig_count input))))))
