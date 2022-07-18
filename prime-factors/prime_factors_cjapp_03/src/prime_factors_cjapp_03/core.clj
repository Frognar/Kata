(ns prime-factors-cjapp-03.core)


(defn factors-of [n]
  (loop [div 2 n n factors []]
    (if (> n 1)
      (cond
        (> div (Math/sqrt n))
        (conj factors n)
        (zero? (mod n div))
        (recur div (/ n div) (conj factors div))
        :else
        (recur (inc div) n factors))
      factors))
  )