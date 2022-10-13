(ns string-calculator-clj._06.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._06.core :refer :all]))

(describe "String Calculator"
          (it "fails"
              (should= 0 1)))

(run-specs)
