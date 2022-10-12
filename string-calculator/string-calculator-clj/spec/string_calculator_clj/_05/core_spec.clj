(ns string-calculator-clj._05.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._05.core :refer :all]))

(describe "String Calculator"
          (it "nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          (it "'1' -> 1"
              (should= 1 (add "1")))
          (it "'2,3' -> 5"
              (should= 5 (add "2,3")))
          )

(run-specs)
