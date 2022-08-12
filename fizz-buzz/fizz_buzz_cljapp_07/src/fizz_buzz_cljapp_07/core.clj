(ns fizz-buzz-cljapp-07.core)

(defn fizz? [n] (zero? (mod n 3)))
(defn buzz? [n] (zero? (mod n 5)))
(defn fizzbuzz? [n] (and (fizz? n) (buzz? n)))

(defn fizz-buzz [n]
  (cond
    (fizzbuzz? n) "FizzBuzz"
    (fizz? n) "Fizz"
    (buzz? n) "Buzz"
    :else (str n))
  )

(defn render [count r]
  (loop [n 1 rendered []]
    (if (> n count)
      rendered
      (recur (inc n) (conj rendered (r n))))
    )
  )
