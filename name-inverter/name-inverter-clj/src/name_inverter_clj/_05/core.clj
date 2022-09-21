(ns name-inverter-clj._05.core
  (:require [clojure.string :as str]))

(defn invert-parts [name_parts]
  (let [[first last] [(first name_parts) (second name_parts)]]
    (str last ", " first)))

(def any-amount-of-spaces #"\s+")

(defn break-into-parts-ignoring-whitespaces [name]
  (str/split (str/trim name) any-amount-of-spaces))

(defn invert [name]
  (let [name_parts (break-into-parts-ignoring-whitespaces name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (if (= "Mr." (first name_parts))
        (invert-parts (drop 1 name_parts))
        (invert-parts name_parts)))))
