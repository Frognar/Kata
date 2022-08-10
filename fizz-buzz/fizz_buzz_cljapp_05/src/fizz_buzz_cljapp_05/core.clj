(ns fizz-buzz-cljapp-05.core)

(defn fizz? [n]
  (zero? (mod n 3)))

(defn fizz-buzz [n]
  (cond
    (fizz? n) "Fizz"
    (zero? (mod n 5)) "Buzz"
    :else (str n)
    )
  )

