(ns name-inverter-clj._03.core
  (:require [clojure.string :as str]))

(defn invert-parts [name_parts]
  (let [[first last] [(first name_parts) (second name_parts)]]
    (str last ", " first)))

(defn is-honorific? [s]
  (= s "Mr."))

(defn without-honorifics [name_parts]
  (if (is-honorific? (first name_parts))
    (rest name_parts)
    name_parts))

(def any-amount-of-whitespaces #"\s+")

(defn break-into-parts-ignoring-whitespaces [name]
  (str/split (str/trim name) any-amount-of-whitespaces))

(defn invert [name]
    (let [name_parts (break-into-parts-ignoring-whitespaces name)]
      (if (< (count name_parts) 2)
        (first name_parts)
        (invert-parts (without-honorifics name_parts)))))
