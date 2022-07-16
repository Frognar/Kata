(ns prime-factors-cjapp-01.core)


(defn factors-of [n]
  (loop [div 2 n n factors []]
    (if (> n 1)
    (if (zero? (mod n div))
      (recur div
             (/ n div)
             (conj factors div))
      (recur (inc div) n factors))
    factors)))