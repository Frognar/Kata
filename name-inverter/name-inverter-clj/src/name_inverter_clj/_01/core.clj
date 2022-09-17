(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(defn invert [name]
    (let [first (first (str/split name #" "))]
      (if (nil? first)
        ""
        first)
    )
  )
