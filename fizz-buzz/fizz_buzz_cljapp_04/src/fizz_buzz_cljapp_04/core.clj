(ns fizz-buzz-cljapp-04.core)

(defn fizz? [number]
  (zero? (mod number 3)))

(defn buzz? [number]
  (zero? (mod number 5)))

(defn fizzbuzz? [number]
  (and (fizz? number) (buzz? number)))

(defn fizz-buzz [number]
  (cond
    (fizzbuzz? number) "FizzBuzz"
    (fizz? number) "Fizz"
    (buzz? number) "Buzz"
    :else (str number)
    )
  )

(defn render [count rend]
  (loop [n 1 rendered []]
    (if (> n count)
      rendered
      (recur (inc n) (conj rendered (rend n))))
    )
  )
