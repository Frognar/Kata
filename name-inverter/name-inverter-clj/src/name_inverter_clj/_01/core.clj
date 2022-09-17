(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(defn invert [name]
    (let [name_parts (str/split name #" ")]
      (if (< (count name_parts) 1)
        ""
        (first name_parts))
    )
  )
