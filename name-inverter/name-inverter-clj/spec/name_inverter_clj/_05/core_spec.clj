(ns name-inverter-clj._05.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._05.core :refer :all]))

(describe "Name inverter"
          (it "invert nil should throw exception"
              (should-throw (invert nil)))
          )
