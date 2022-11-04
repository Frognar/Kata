(ns look-and-say-clj._07.core)

(defn say [count input] (str count input))

(defn look-and-say [input]
  (let [count 1
        current (first input)
        rest-input (rest input)]
    (if (not (nil? (second input)))
      (if (= current (first rest-input))
        (say (inc count) current)
        (str count current count (second input)))
      (say count current))))
