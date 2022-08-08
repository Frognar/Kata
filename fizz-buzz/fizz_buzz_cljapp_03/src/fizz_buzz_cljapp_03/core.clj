(ns fizz-buzz-cljapp-03.core)

(defn fizz? [number]
  (= number 3))

(defn fizz-buzz [number]
  (cond
    (fizz? number) "Fizz"
    (= number 5) "Buzz"
    :else (str number)))
