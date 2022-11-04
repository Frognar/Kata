(ns look-and-say-clj._07.core)

(defn say [count input] (str count input))

(defn look-and-say [input]
  (let [count 1
        [current & input] input
        rest-input input]
    (if (not (nil? (first rest-input)))
      (if (= current (first rest-input))
        (say (inc count) current)
        (str count current count (first rest-input)))
      (say count current))))
