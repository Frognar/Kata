(ns string-calculator-clj._01.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._01.core :refer :all]))

(describe "String Calculator"
          (it "nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          (it "'1' -> 1"
              (should= 1 (add "1")))
          (it "'2' -> 2"
              (should= 2 (add "2")))
          )

(run-specs)