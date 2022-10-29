(ns look-and-say-clj.core
  (:require [clojure.string :as str]))

(defn look-and-say [input]
  (loop [res []
         [current & input] input
         count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur res input (inc count))
        (recur (conj res (str count current)) input 1))
      (str (str/join res) count current))))

(defn look-and-say-sequence [input depth]
  (loop [res [input]
         current input
         depth depth]
    (if (> depth 0)
      (let [current (look-and-say current)]
        (recur (conj res (str ":" current)) current (dec depth)))
      (str/join res))))