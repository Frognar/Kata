(ns name-inverter-clj._02.core
  (:require [clojure.string :as str]))

(defn invert [name]
    (str/trim name))
