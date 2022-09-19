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
          (it "invert 'Horus' -> 'Horus'"
              (should= "Horus" (invert "Horus")))
          (it "invert 'Horus Lupercal' -> 'Lupercal, Horus'"
              (should= "Lupercal, Horus" (invert "Horus Lupercal")))
          (it "invert 'Horus   Lupercal' -> 'Lupercal, Horus'"
              (should= "Lupercal, Horus" (invert "Horus   Lupercal")))
          (it "invert 'Mr. Horus Lupercal' -> 'Lupercal, Horus'"
              (should= "Lupercal, Horus" (invert "Mr. Horus Lupercal")))
          (it "invert 'Mrs. Horus Lupercal' -> 'Lupercal, Horus'"
              (should= "Lupercal, Horus" (invert "Mrs. Horus Lupercal")))
          )