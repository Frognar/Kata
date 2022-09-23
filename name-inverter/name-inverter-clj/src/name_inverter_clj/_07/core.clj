(ns name-inverter-clj._07.core
  (:require [clojure.string :as str]))

(defn break-into-parts [name]
  (str/split (str/trim name) #" "))

(defn invert [name]
  (let [name_parts (break-into-parts name)]
    (first name_parts)))
