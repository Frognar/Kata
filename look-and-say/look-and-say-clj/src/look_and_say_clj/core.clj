(ns look-and-say-clj.core)

(defn look-and-say [input]
  (loop [input input
         dig_count 1]
    (if (> (count input) 1)
      (let [index 0
            count dig_count
            current_digit (nth input index)
            next_digit (nth input (inc index))]
        (if (= current_digit next_digit)
          (str (inc count) current_digit)
          (str count current_digit count next_digit)))
      (str dig_count input))))