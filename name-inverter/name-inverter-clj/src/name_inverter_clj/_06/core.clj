(ns name-inverter-clj._06.core
  (:require [clojure.string :as str]))

(defn find-and-merge-postnominals [name_parts]
  (str/join " " name_parts))

(defn invert-parts [[first last & name_parts]]
  (let [postnominals (find-and-merge-postnominals name_parts)]
    (str/trim (str last ", " first " " postnominals))))

(defn is-honorifics? [s]
  (let [known-honorifics #{"Mr.", "Mrs."}]
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
