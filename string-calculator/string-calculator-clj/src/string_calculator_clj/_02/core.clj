(ns string-calculator-clj._02.core)

(defn add [numbers]
  (if (empty? numbers)
    0
    (Integer/parseInt numbers)))
