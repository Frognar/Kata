(ns string-calculator-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._04.core :refer :all]))

(describe "String Calculator"
          (it "fail"
              (should= 1 0))
          )

(run-specs)
