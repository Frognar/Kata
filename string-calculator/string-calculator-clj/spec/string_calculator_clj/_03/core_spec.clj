(ns string-calculator-clj._03.core-spec
  (:require [speclj.core :refer :all]))

(describe "String Calculator"
          (it "Fail"
              (should= 0 1))
          )

(run-specs)
