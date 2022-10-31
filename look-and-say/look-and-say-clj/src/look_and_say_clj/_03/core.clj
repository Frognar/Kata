(ns look-and-say-clj._03.core)

(defn look-and-say [input]
  (let [current (first input)
        digit_count 1]
    (if (= (count input) 2)
      (if (= current (second input))
        (str 2 current)
        (str 1 current 1 (second input)))
      (str digit_count input))))