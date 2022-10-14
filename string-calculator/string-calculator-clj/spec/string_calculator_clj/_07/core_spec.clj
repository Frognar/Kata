(ns string-calculator-clj._07.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._07.core :refer :all]))

(describe "String Calculator"
          (it "fails"
              (should= 0 1))
          )

(run-specs)
