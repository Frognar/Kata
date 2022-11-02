(ns look-and-say-clj._05.core)

(defn look-and-say [input]
  (let [[current & input] input
        count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (str 2 current)
        (str 1 current 1 (first input)))
      (str count current))))
