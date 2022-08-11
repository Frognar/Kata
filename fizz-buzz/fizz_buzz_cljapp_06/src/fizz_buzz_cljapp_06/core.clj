(ns fizz-buzz-cljapp-06.core)

(defn fizz? [n]
  (zero? (mod n 3)))

(defn buzz? [n]
  (zero? (mod n 5)))

(defn fizz-buzz [n]
  (cond
    (and (fizz? n) (buzz? n)) "FizzBuzz"
    (fizz? n) "Fizz"
    (buzz? n) "Buzz"
    :else (str n))
  )
