(ns name-inverter-clj._04.core
  (:require [clojure.string :as str]))

(defn invert-parts [[first last & _]]
    (str last ", " first))

(def any-amount-of-whitespaces #"\s+")

(defn break-into-parts-ignoring-whitespaces [name]
  (str/split (str/trim name) any-amount-of-whitespaces))

(defn invert [name]
  (let [name_parts (break-into-parts-ignoring-whitespaces name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (invert-parts name_parts))))
