(ns look-and-say-clj._04.core)

(defn look-and-say [input]
  (let [input input]
    (if (not (nil? (second input)))
      (if (= (first input) (second input))
        (str 2 (first input))
        (str 1 (first input) 1 (second input)))
      (str 1 input))))
