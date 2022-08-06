(ns fizz-buzz-cljapp-01.core)

(defn fizz-buzz
  [number]
  (cond
    (zero? (mod number 3))
    "Fizz"
    (zero? (mod number 5))
    "Buzz"
    :else
    (str number)))
