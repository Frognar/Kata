(ns string-calculator-clj._02.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._02.core :refer :all]))

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
          (it "'//@\n6@7' -> 13"
              (should= 13 (add "//@\n6@7")))
          (it "'//[%]\n8%9' -> 17"
              (should= 17 (add "//[%]\n8%9")))
          (it "'//[>][<]\n10>11<12' -> 33"
              (should= 33 (add "//[>][<]\n10>11<12")))
          )

(run-specs)
