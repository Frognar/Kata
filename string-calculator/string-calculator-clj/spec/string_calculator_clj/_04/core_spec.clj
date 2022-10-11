(ns string-calculator-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._04.core :refer :all]))

(describe "String Calculator"
          (it "nil -> 0"
              (should= 0 (add nil)))
          )

(run-specs)
