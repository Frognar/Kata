(ns look-and-say-clj._03.core)

(defn look-and-say [input]
  (let [current (first input)]
    (if (= (count input) 2)
      (if (= current (second input))
        (str 2 current)
        (str 1 (first input) 1 (second input)))
      (str 1 input))))