(ns name-inverter-clj._07.core
  (:require [clojure.string :as str]))

(defn invert-parts [name_parts]
  (str (second name_parts) ", " (first name_parts)))

(defn break-into-parts [name]
  (let [space #" "]
    (str/split (str/trim name) space)))

(defn invert [name]
  (let [name_parts (break-into-parts name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (invert-parts name_parts))))
