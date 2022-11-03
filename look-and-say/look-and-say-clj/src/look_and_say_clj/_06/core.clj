(ns look-and-say-clj._06.core)

(defn look-and-say [input]
  (if (= (count input) 2)
    (str 2 (first input))
    (str 1 input)))
