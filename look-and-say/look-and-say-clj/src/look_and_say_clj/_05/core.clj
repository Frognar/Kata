(ns look-and-say-clj._05.core)

(defn look-and-say [input]
  (if (not (nil? (second input)))
    (if (= (first input) (second input))
      (str 2 (first input))
      (str 1 (first input) 1 (second input)))
    (str 1 (first input))))
