(ns fizz-buzz-cljapp-02.core)

(defn fizz? [number]
  (zero? (mod number 3)))

(defn buzz? [number]
  (zero? (mod number 5)))

(defn fizzbuzz? [number]
  (= number 15))

(defn -main
  [& args]
  (println "Hello World"))
