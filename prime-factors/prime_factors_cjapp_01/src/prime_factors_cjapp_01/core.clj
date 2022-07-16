(ns prime-factors-cjapp-01.core)


(defn factors-of [n]
  (if (> n 1)
    (if (zero? (mod n 2))
      (concat [2] (factors-of (/ n 2)))
      (if (zero? (mod n 3))
        (concat [3] (factors-of (/ n 3)))
        [n]))
    [])
  )