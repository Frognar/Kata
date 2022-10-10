(ns string-calculator-clj._03.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._03.core :refer :all]))

(describe "String Calculator"
          (it "Nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          )

(run-specs)
