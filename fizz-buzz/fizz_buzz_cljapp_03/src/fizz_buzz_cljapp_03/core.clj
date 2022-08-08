(ns fizz-buzz-cljapp-03.core)

(defn fizz-buzz [number]
  (if (= number 3)
    "Fizz"
    (str number)))
