(ns name-inverter-clj._07.core
  (:require [clojure.string :as str]))

(defn find-and-merge-postnominals [name_parts]
  (str/join " " (drop 2 name_parts)))

(defn invert-parts [name_parts]
    (let [[first last] [(first name_parts) (second name_parts)]
          postnominals (find-and-merge-postnominals name_parts)]
      (str/trim (str last ", " first " " postnominals))))

(defn is-honorific? [s]
  (let [known-honorifics #{"Mr.", "Mrs."}]
    (contains? known-honorifics s)))

(defn without-honorifics [name_parts]
  (if (is-honorific? (first name_parts))
    (drop 1 name_parts)
    name_parts))

(defn break-into-parts-ignoring-whitespaces [name]
  (let [any-amount-of-whitespaces #"\s+"]
    (str/split (str/trim name) any-amount-of-whitespaces)))

(defn invert [name]
  (let [name_parts (break-into-parts-ignoring-whitespaces name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (invert-parts (without-honorifics name_parts)))))
