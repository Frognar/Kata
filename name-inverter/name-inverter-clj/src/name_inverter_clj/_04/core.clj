(ns name-inverter-clj._04.core
  (:require [clojure.string :as str]))

(defn invert-parts [[first last & _]]
    (str last ", " first))

(def space #" ")

(defn break-into-parts [name]
  (str/split (str/trim name) space))

(defn invert [name]
  (let [name_parts (break-into-parts name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (invert-parts name_parts))))
