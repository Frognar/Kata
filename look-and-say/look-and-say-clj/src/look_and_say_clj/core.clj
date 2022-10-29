(ns look-and-say-clj.core)

(defn look-and-say [input]
  (loop [input input
         dig_count 1]
    (if (> (count input) 1)
      (let [index 0
            current_digit (nth input index)
            next_digit (nth input (inc index))]
        (if (= (first input) next_digit)
          (str (inc dig_count) (first input))
          (str dig_count (first input) dig_count (second input))))
      (str dig_count input))))