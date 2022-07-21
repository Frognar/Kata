(ns prime-factors-cjapp-06.core)


(defn factors-of [n]
  (if (> n 1)
    (cond
      (zero? (mod n 2))
      (concat [2] (factors-of (/ n 2)))
      (zero? (mod n 3))
      (concat [3] (factors-of (/ n 3)))
      :else
      [n])
    []))
