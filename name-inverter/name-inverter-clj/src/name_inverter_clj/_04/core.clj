(ns name-inverter-clj._04.core
  (:require [clojure.string :as str]))

(def space #" ")

(defn break-into-parts [name]
  (str/split (str/trim name) space))

(defn invert [name]
  (let [name_parts (break-into-parts name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (str (second name_parts) ", " (first name_parts)))))
