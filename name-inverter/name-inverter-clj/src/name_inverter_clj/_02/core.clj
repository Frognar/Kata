(ns name-inverter-clj._02.core
  (:require [clojure.string :as str]))

(def any-amount-of-whitespaces #"\s+")

(defn break-into-parts [name]
  (str/split (str/trim name) any-amount-of-whitespaces))

(defn invert [name]
  (let [name_parts (break-into-parts name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (str (second name_parts) ", " (first name_parts))
      )))
