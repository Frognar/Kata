(ns name-inverter-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._04.core :refer :all]))

(describe "Name inverter"
          (it "invert nil should throw exception"
              (should-throw (invert nil)))
          )