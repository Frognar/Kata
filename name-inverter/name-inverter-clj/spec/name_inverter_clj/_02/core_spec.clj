(ns name-inverter-clj._02.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._02.core :refer :all]))

(describe "Name Inverter"
          (it "Should throw exception when invert nil"
              (should-throw (invert nil)))
          (it "invert '' -> ''"
              (should= "" (invert "")))
          (it "invert '  ' -> ''"
              (should= "" (invert "  ")))
          (it "invert 'Horus' -> 'Horus'"
              (should= "Horus" (invert "Horus")))
          )

