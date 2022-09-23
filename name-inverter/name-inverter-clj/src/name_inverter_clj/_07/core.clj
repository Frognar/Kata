(ns name-inverter-clj._07.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (str/trim name))
