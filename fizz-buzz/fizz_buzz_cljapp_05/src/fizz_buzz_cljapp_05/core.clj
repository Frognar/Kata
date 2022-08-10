(ns fizz-buzz-cljapp-05.core)

(defn fizz? [n]
  (zero? (mod n 3)))

(defn buzz? [n]
  (zero? (mod n 5)))

(defn fizzbuzz? [n]
  (and (fizz? n) (buzz? n)))

(defn fizz-buzz [n]
  (cond
    (fizzbuzz? n)"FizzBuzz"
    (fizz? n) "Fizz"
    (buzz? n) "Buzz"
    :else (str n)
    )
  )

