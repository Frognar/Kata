(ns name-inverter-clj._06.core
  (:require [clojure.string :as str]))

(defn invert-parts [name_parts]
  (str (second name_parts) ", " (first name_parts)))

(defn is-honorifics? [s]
  (let [known-honorifics #{"Mr."}]
    (contains? known-honorifics s)))

(defn without-honorifics [name_parts]
  (if (is-honorifics? (first name_parts))
    (rest name_parts)
    name_parts))

(defn break-into-parts-ignoring-whitespaces [name]
  (let [any-amount-of-whitespaces #"\s+"]
    (str/split (str/trim name) any-amount-of-whitespaces)))

(defn invert [name]
    (let [name_parts (break-into-parts-ignoring-whitespaces name)]
      (if (< (count name_parts) 2)
        (first name_parts)
        (invert-parts (without-honorifics name_parts)))))
