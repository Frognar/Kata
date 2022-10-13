(ns string-calculator-clj._06.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._06.core :refer :all]))

(describe "String Calculator"
          (it "nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          (it "'1' -> 1"
              (should= 1 (add "1")))
          (it "'2,4' -> 6"
              (should= 6 (add "2,4")))
          )

(run-specs)