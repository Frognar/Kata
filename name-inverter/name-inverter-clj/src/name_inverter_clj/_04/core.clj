(ns name-inverter-clj._04.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (let [name_parts (str/split (str/trim name) #" ")]
    (if (< (count name_parts) 2)
      (first name_parts)
      (str (second name_parts) ", " (first name_parts)))))
