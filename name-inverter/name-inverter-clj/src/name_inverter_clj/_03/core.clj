(ns name-inverter-clj._03.core
  (:require [clojure.string :as str]))

(defn invert-parts [name_parts]
  (let [[first last] [(first name_parts) (second name_parts)]]
    (str last ", " first)))

(def space #" ")

(defn break-into-parts [name] (str/split (str/trim name) space))

(defn invert [name]
    (let [name_parts (break-into-parts name)]
      (if (< (count name_parts) 2)
        (first name_parts)
        (invert-parts name_parts))))
