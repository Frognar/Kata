(ns look-and-say-clj._06.core)

(defn look-and-say [input]
  (let [count 1
        current (first input)]
    (if (not (nil? (second input)))
      (if (= current (second input))
        (str (inc count) current)
        (str count current count (second input)))
      (str count current))))
