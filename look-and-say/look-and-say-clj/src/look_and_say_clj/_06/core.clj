(ns look-and-say-clj._06.core)

(defn look-and-say [input]
  (let [count 1
        [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (str (inc count) current)
        (str count current count (first input)))
      (str count current))))
