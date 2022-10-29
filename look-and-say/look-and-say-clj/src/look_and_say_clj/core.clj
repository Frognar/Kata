(ns look-and-say-clj.core)

(defn look-and-say [input]
  (if (> (count input) 1)
    (if (= (first input) (second input))
      (str 2 (first input))
      (str 1 (first input) 1 (second input)))
    (str 1 input)))