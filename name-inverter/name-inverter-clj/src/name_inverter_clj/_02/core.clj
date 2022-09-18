(ns name-inverter-clj._02.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (let [name_parts (str/split (str/trim name) #"\s")]
    (if (< (count name_parts) 2)
      (first name_parts)
      (str (second name_parts) ", " (first name_parts))
      )))
