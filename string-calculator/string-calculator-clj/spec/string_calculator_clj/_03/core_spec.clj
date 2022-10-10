(ns string-calculator-clj._03.core-spec
  (:require [speclj.core :refer :all]
            [string-calculator-clj._03.core :refer :all]))

(describe "String Calculator"
          (it "Nil -> 0"
              (should= 0 (add nil)))
          (it "'' -> 0"
              (should= 0 (add "")))
          (it "'10' -> 10"
              (should= 10 (add "10")))
          (it "'11,12' -> 23"
              (should= 23 (add "11,12")))
          (it "'13\n14' -> 27"
              (should= 27 (add "13\n14")))
          (it "'//;\n15;16' -> 31"
              (should= 31 (add "//;\n15;16")))
          )

(run-specs)
