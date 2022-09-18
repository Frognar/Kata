(ns name-inverter-clj._02.core
  (:require [clojure.string :as str]))

(defn find-postnominal [name_parts]
  (if (< (count name_parts) 3)
    ""
    (str/join " " (drop 2 name_parts))))

(defn invert-parts [name_parts]
  (let [[first last] [(first name_parts) (second name_parts)]
        postnominal (find-postnominal name_parts)]
  (str/trim (str last ", " first " " postnominal))))

(def known-honorifics #{"Mr.", "Mrs."})

(defn is-honorific? [s] (contains? known-honorifics s))

(defn without-honorifics [name_parts]
  (if (is-honorific? (first name_parts))
    (rest name_parts)
    name_parts))

(def any-amount-of-whitespaces #"\s+")

(defn break-into-parts [name]
  (str/split (str/trim name) any-amount-of-whitespaces))

(defn invert [name]
  (let [name_parts (break-into-parts name)]
    (if (< (count name_parts) 2)
      (first name_parts)
      (invert-parts (without-honorifics name_parts))
      )))
