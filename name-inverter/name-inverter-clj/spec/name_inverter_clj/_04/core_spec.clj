(ns name-inverter-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._04.core :refer :all]))

(describe "Name inverter"
          (it "invert nil should throw exception"
              (should-throw (invert nil)))
          (it "invert '' -> ''"
              (should= "" (invert "")))
          (it "invert '  ' -> ''"
              (should= "" (invert "  ")))
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
          (it "invert 'Horus Lupercal Sr.' -> 'Lupercal, Horus Sr.'"
              (should= "Lupercal, Horus Sr." (invert "Horus Lupercal Sr.")))
          )