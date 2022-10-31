(ns look-and-say-clj._03.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (let [result []
        current (first input)
        digit_count 1]
    (if (= (count input) 2)
      (if (= current (second input))
        (str/join (conj result (str (inc digit_count) current)))
        (str/join (conj result (str digit_count current digit_count (second input)))))
      (str/join (conj result (str digit_count current))))))