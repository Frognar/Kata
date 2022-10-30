(ns look-and-say-clj._02.core)

(defn look-and-say [input]
  (let [dig_count 1]
    (if (= (count input) 2)
      (if (= (first input) (second input))
        (str 2 (first input))
        (str dig_count (first input) 1 (second input)))
      (str dig_count input))))
