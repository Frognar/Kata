(ns look-and-say-clj._05.core)

(defn look-and-say [input]
  (let [current (first input)]
    (if (not (nil? (second input)))
      (if (= current (second input))
        (str 2 current)
        (str 1 current 1 (second input)))
      (str 1 current))))
