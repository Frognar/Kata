(ns fizz-buzz-cljapp-03.core)

(defn fizz? [number]
  (= number 3))

(defn buzz? [number]
  (= number 5))

(defn fizz-buzz [number]
  (cond
    (fizz? number) "Fizz"
    (buzz? number) "Buzz"
    :else (str number)))
