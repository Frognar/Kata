(ns name-inverter-clj._06.core
  (:require [clojure.string :as str]))

(defn invert [name]
    (let [name_parts (str/split (str/trim name) #" ")]
      (first name_parts)))
