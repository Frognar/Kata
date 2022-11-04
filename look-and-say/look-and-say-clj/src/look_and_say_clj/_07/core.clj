(ns look-and-say-clj._07.core)

(defn say [count input] (str count input))

(defn look-and-say [input]
  (let [count 1
        [current & input] input]
    (if (not (nil? input))
      (if (= current (first input))
        (say (inc count) current)
        (str count current count (first input)))
      (say count current))))
