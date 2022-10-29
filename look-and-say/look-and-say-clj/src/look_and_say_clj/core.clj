(ns look-and-say-clj.core)

(defn look-and-say [input]
  (if (> (count input) 1)
    (if (= (nth input 0) (second input))
      (str 2 (nth input 0))
      (str 1 (first input) 1 (second input)))
    (str 1 input)))