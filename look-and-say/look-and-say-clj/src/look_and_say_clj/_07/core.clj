(ns look-and-say-clj._07.core)

(defn say [count input] (str count input))

(defn look-and-say [input]
  (if (not (nil? (second input)))
    (say 2 (first input))
    (say 1 (first input))))
