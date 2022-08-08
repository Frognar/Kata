(ns fizz-buzz-cljapp-03.core)

(defn fizz? [number]
  (= number 3))

(defn fizz-buzz [number]
  (if (fizz? number)
    "Fizz"
    (str number)))
