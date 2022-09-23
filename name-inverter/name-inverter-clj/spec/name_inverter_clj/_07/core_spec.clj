(ns name-inverter-clj._07.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._07.core :refer :all]))

(describe "Name Inverter"
          (it "invert nil should throw exception"
              (should-throw (invert nil)))
          (it "invert '' -> ''"
              (should= "" (invert "")))
          (it "invert '   ' -> ''"
              (should= "" (invert "   ")))
          )
