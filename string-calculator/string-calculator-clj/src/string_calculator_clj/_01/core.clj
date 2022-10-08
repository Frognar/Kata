(ns string-calculator-clj._01.core
  (:require [clojure.string :as str]))

(defn add [numbers]
  (if (or (nil? numbers) (empty? numbers))
    0
      (reduce + (map #(Integer/parseInt %) (str/split numbers #","))))
    )
