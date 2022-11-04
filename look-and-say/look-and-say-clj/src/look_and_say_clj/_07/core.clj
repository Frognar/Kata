(ns look-and-say-clj._07.core)

(defn say [count input] (str count input))

(defn look-and-say [input]
  (let [count 1]
    (if (not (nil? (second input)))
      (if (= (first input) (second input))
        (say 2 (first input))
        (str 1 (first input) count (second input)))
      (say count (first input)))))
