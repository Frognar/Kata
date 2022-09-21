(ns name-inverter-clj._05.core
  (:require [clojure.string :as str]))

(defn invert [name]
    (str/trim name))
