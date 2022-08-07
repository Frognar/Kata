(ns fizz-buzz-cljapp-02.core)

(defn fizz? [number]
  (zero? (mod number 3)))

(defn buzz? [number]
  (zero? (mod number 5)))

(defn fizzbuzz? [number]
  (and (fizz? number) (buzz? number)))

(defn fizzbuzz [number]
  (cond
    (fizz? number) "Fizz"
    (buzz? number) "Buzz"
    :else (str number)
    ))

(defn -main
  [& args]
  (println "Hello World"))
