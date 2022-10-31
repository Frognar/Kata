(ns look-and-say-clj._03.core)

(defn look-and-say [input]
  (let [current (first input)
        digit_count 1]
    (if (= (count input) 2)
      (if (= current (second input))
        (str 2 current)
        (str digit_count current digit_count (second input)))
      (str digit_count input))))