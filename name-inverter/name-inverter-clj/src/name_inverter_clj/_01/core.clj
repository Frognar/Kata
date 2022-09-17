(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(defn break-into-parts [name]
  (str/split name #" "))

(defn invert [name]
    (let [name_parts (break-into-parts name)]
      (if (< (count name_parts) 1)
        ""
        (first name_parts))
    )
  )
