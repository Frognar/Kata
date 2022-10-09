(ns string-calculator-clj._02.core-spec
  (:require [speclj.core :refer :all]))

(describe "String Calculator"
          (it "fail"
              (should= 0 1)))

(run-specs)
