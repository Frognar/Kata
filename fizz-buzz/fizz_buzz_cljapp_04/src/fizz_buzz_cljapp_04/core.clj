(ns fizz-buzz-cljapp-04.core)

(defn fizz? [number]
  (zero? (mod number 3)))


(defn fizz-buzz [number]
  (cond
    (fizz? number) "Fizz"
    (zero? (mod number 5)) "Buzz"
    :else (str number)
    )
  )
