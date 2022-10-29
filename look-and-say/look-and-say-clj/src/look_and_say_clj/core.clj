(ns look-and-say-clj.core)

(defn look-and-say [input]
  (if (> (count input) 1)
    (if (= (nth input 0) (nth input 1))
      (str 2 (nth input 0))
      (str 1 (nth input 0) 1 (nth input 1)))
    (str 1 input)))