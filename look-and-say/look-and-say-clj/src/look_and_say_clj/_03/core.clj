(ns look-and-say-clj._03.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (let [result []
        [current & input] input
        digit_count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (str/join (conj result (str (inc digit_count) current)))
        (str/join (conj result (str digit_count current digit_count (first input)))))
      (str/join (conj result (str digit_count current))))))