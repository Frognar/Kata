(ns fizz-buzz-cljapp-04.core)


(defn fizz-buzz [number]
  (cond
    (= number 3) "Fizz"
    (= number 5) "Buzz"
    :else (str number)
    )
  )
