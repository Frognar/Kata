(ns prime-factors-cjapp-01.core
  (:require [clojure.set :as set]
            [clojure.data.int-map :as int-map]))

(defn factors-of [n]
  (loop [div 2 n n factors []]
    (if (> n 1)
      (cond
        (> div (Math/sqrt n))
        (conj factors n)
        (zero? (mod n div))
        (recur div
               (/ n div)
               (conj factors div))
        :else
        (recur (inc div) n factors))
      factors)))


(defn remove-multiples-of-first [candidates]
  (let [first-candidate (first candidates)
        factors (int-map/int-set (range first-candidate
                                  (inc (last candidates))
                                  first-candidate))
        new-candidates (set/difference candidates factors)]
    new-candidates))

(defn primes-up-to [limit]
  (loop [candidates (int-map/int-set (range 2 (inc limit)))
         primes []]
    (if (empty? candidates)
      primes
      (recur (remove-multiples-of-first candidates)
             (conj primes (first candidates))))
    ))