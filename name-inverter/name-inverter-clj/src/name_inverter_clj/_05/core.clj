(ns name-inverter-clj._05.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (let [name_parts (str/split (str/trim name) #" ")]
    (first name_parts)))
