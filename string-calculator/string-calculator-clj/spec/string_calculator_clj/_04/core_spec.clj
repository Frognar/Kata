(ns string-calculator-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._04.core :refer :all]))

(describe "String Calculator"
          (it "nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          (it "'1' -> 1"
              (should= 1 (add "1")))
          (it "'2,3' -> 5"
              (should= 5 (add "2,3")))
          (it "'4\n5' -> 9"
              (should= 9 (add "4\n5")))
          )

(run-specs)
