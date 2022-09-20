(ns name-inverter-clj._04.core
  (:require [clojure.string :as str]))

(defn invert [name]
  (str/trim name))
