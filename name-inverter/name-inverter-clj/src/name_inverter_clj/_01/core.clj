(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(def any-amount-of-whitespaces #"\s+")

(defn break-into-parts-ignoring-whitespaces [name]
  (str/split name any-amount-of-whitespaces))

(defn invert-parts [name_parts]
  (let [first (first name_parts)
        last (second name_parts)
        postnominals (if (< (count name_parts) 3) "" (nth name_parts 2))]
    (str/trim (str last ", " first " " postnominals))
  ))

(def known-honorifics #{"Mr.", "Mrs."})

(defn is-honorific? [s]
    (contains? known-honorifics s))

(defn without-honorifics [name_parts]
  (remove #(is-honorific? %) name_parts))

(defn invert [name]
    (let [name_parts (break-into-parts-ignoring-whitespaces name)]
      (cond
        (< (count name_parts) 1) ""
        (< (count name_parts) 2) (first name_parts)
        :else (invert-parts (without-honorifics name_parts))
        )
      )
  )
