(ns look-and-say-clj._02.core)

(defn look-and-say [input]
  (let [dig_count 1]
    (if (= (count input) 2)
      (if (= (first input) (second input))
        (str (inc dig_count) (first input))
        (str dig_count (first input) dig_count (second input)))
      (str dig_count input))))
