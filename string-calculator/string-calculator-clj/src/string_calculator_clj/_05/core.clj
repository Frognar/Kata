(ns string-calculator-clj._05.core)

(defn convert [numbers] (Integer/parseInt numbers))

(defn add [numbers]
  (if (empty? numbers)
    0
    (convert numbers)))