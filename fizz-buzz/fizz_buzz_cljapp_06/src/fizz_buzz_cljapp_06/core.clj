(ns fizz-buzz-cljapp-06.core)

(defn fizz? [n]
  (zero? (mod n 3)))

(defn fizz-buzz [n]
  (cond
    (fizz? n) "Fizz"
    (= n 5) "Buzz"
    :else (str n))
  )
