(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (if (nil? name)
    (throw NullPointerException)
    (let [first (first (str/split name #" "))]
      (if (nil? first)
        ""
        first)
    ))
  )
