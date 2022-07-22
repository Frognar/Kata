(ns prime-factors-cjapp-07.core)

(defn factors-of [n]
  (loop [div 2 n n factors []]
    (if (> n 1)
    (cond
      (zero? (mod n div))
      (recur div (/ n div) (conj factors div))
      :else
      (recur (inc div) n factors))
    factors)))
