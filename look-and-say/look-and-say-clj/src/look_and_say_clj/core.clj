(ns look-and-say-clj.core)

(defn look-and-say [input]
  (if (> (count input) 1)
    (let [current_digit (nth input 0)]
      (if (= current_digit (nth input 1))
        (str 2 current_digit)
        (str 1 (nth input 0) 1 (nth input 1))))
    (str 1 input)))