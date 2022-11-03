(ns look-and-say-clj._06.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (let [result []
        count 1
        [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (str (inc count) current)
        (str count current count (first input)))
      (str/join (conj result (str count current))))))
