(ns look-and-say-clj._05.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (let [result []
        count 1
        [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (str/join (conj result (str (inc count) current)))
        (str/join (conj result (str count current count (first input)))))
      (str/join (conj result (str count current))))))
