(ns look-and-say-clj._04.core)

(defn look-and-say [input]
  (loop [[current & input] input
          count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (str (inc count) (first input))
        (str count current count (first input)))
      (str count current))))
