(ns fizz-buzz-cljapp-04.core)


(defn fizz-buzz [number]
  (if (= number 3)
    "Fizz"
    (str number)))
