(ns name-inverter-clj._02.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (let [name_parts (str/split (str/trim name) #"\s")]
    (first name_parts)))
