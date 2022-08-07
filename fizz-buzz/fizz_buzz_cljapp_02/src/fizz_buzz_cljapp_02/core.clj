(ns fizz-buzz-cljapp-02.core)

(defn fizz? [number]
  (zero? (mod number 3)))

(defn buzz? [number]
  (= number 5))

(defn -main
  [& args]
  (println "Hello World"))
