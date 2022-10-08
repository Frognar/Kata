(ns string-calculator-clj._01.core)

(defn add [numbers]
  (if (or (nil? numbers) (empty? numbers))
    0
    (Integer/parseInt numbers)))
