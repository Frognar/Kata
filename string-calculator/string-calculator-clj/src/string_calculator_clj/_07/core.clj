(ns string-calculator-clj._07.core)

(defn convert-to-integer [number] (Integer/parseInt number))

(defn add [numbers]
  (if (empty? numbers)
    0
    (convert-to-integer numbers)))
