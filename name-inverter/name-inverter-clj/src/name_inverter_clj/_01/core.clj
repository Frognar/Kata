(ns name-inverter-clj._01.core
  (:require [clojure.string :as str]))

(def any-amount-of-whitespaces
  #"\s+")

(defn break-into-parts-ignoring-whitespaces [name]
  (str/split name any-amount-of-whitespaces))

(defn invert-parts [name_parts]
  (str (second name_parts) ", " (first name_parts)))

(defn is-honorific? [s]
  (= "Mr." s))

(defn invert [name]
    (let [name_parts (break-into-parts-ignoring-whitespaces name)]
      (cond
        (< (count name_parts) 1) ""
        (< (count name_parts) 2) (first name_parts)
        :else (invert-parts (remove #(is-honorific? %) name_parts))
        )
      )
  )
