(ns look-and-say-clj.core)

(defn look-and-say [input]
  (if (> (count input) 1)
    (let [current_digit (nth input 0)
          next_digit (nth input 1)]
      (if (= current_digit next_digit)
        (str 2 current_digit)
        (str 1 current_digit 1 next_digit)))
    (str 1 input)))