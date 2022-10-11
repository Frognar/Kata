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
          (it "'-6' -> throw exception"
              (should-throw (add "-6")))
          (it "'//o\n7o8' -> 15"
              (should= 15 (add "//o\n7o8")))
          (it "'//[o]\n9o10' -> 19"
              (should= 19 (add "//[o]\n9o10")))
          (it "'//[o][q]\n11o12q13' -> 36"
              (should= 36 (add "//[o][q]\n11o12q13")))
          (it "'//[o][oo]\n14o15oo16' -> 45"
              (should= 45 (add "//[o][oo]\n14o15oo16")))
          (it "'999,1000,1001' -> 1999"
              (should= 1999 (add "999,1000,1001")))
          )

(run-specs)
