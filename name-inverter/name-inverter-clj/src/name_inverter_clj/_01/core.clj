(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(defn break-into-parts [name]
  (str/split name #" "))

(defn invert-parts [name_parts]
  (str (second name_parts) ", " (first name_parts)))

(defn invert [name]
    (let [name_parts (break-into-parts name)]
      (cond
        (< (count name_parts) 1) ""
        (< (count name_parts) 2) (first name_parts)
        :else (invert-parts name_parts)
        )
      )
  )
