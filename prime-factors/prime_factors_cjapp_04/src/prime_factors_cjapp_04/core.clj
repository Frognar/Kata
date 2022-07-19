(ns prime-factors-cjapp-04.core)


(defn factors-of [n]
  (if (> n 1)
    (if (zero? (mod n 2))
      (concat [2] (factors-of (/ n 2)))
      [n])
    []))
