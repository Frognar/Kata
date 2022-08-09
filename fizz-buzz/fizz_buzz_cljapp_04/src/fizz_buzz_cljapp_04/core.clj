(ns fizz-buzz-cljapp-04.core)

(defn fizz? [number]
  (zero? (mod number 3)))

(defn buzz? [number]
  (zero? (mod number 5)))

(defn fizz-buzz [number]
  (cond
    (and (fizz? number) (buzz? number)) "FizzBuzz"
    (fizz? number) "Fizz"
    (buzz? number) "Buzz"
    :else (str number)
    )
  )
