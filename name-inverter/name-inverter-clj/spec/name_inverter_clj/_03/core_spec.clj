(ns name-inverter-clj._03.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._03.core :refer :all]))

(describe "Name Inverter"
          (it "Invert nil should throw exception"
              (should-throw (invert nil)))
          (it "invert '' -> ''"
              (should= "" (invert "")))
          (it "invert '   ' -> ''"
              (should= "" (invert "   ")))
          )