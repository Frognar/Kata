(ns fizz-buzz-cljapp-06.core)

(defn fizz-buzz [n]
  (cond
    (zero? (mod n 3)) "Fizz"
    (= n 5) "Buzz"
    :else (str n))
  )
