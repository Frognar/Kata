(ns look-and-say-clj._06.core)

(defn look-and-say [input]
  (let [current (first input)]
    (if (= (count input) 2)
      (str 2 current)
      (str 1 current))))
