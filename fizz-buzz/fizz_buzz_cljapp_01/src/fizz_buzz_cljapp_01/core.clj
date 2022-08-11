(ns fizz-buzz-cljapp-01.core)

(defn fizz-buzz
  [number]
  (cond
    (zero? (mod number 15))
    "FizzBuzz"
    (zero? (mod number 3))
    "Fizz"
    (zero? (mod number 5))
    "Buzz"
    :else
    (str number)))

(defn render
  [count renderer]
  (loop [n 1 rendered []]
    (if (<= n count)
      (recur (inc n) (conj rendered (renderer n)))
      rendered))
  )
