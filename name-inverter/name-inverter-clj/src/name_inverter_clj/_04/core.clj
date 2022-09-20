(ns name-inverter-clj._04.core
  (:require [clojure.string :as str]))

(defn find-and-merge-postnominals [name_parts]
  (str/join " " name_parts))

(defn invert-parts [[first last & name_parts]]
    (let [postnominals (find-and-merge-postnominals name_parts)]
      (str/trim (str last ", " first " " postnominals))))

(def known-honorifics #{"Mr.", "Mrs."})

(defn is-honorific? [s]
    (contains? known-honorifics s))

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
