(ns look-and-say-clj._04.core)

(defn look-and-say [input]
  (let [[current & input] input
        count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (str 2 current)
        (str count current 1 (first input)))
      (str count current))))
