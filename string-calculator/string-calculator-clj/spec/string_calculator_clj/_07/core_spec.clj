(ns string-calculator-clj._07.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._07.core :refer :all]))

(describe "String Calculator"
          (it "nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          (it "'1' -> 1"
              (should= 1 (add "1")))
          (it "'3,5' -> 8"
              (should= 8 (add "3,5")))
          )

(run-specs)
