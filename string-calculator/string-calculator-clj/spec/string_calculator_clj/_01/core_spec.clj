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
          (it "'1,2' -> 3"
              (should= 3 (add "1,2")))
          (it "'1\n2' -> 3"
              (should= 3 (add "1\n2")))
          (it "'1\n2,3' -> 6"
              (should= 6 (add "1\n2,3")))
          (it "'//>\n1>3' -> 4"
              (should= 4 (add "//>\n1>3")))
          (it "'//[>]\n1>3' -> 4"
              (should= 4 (add "//[>]\n1>3")))
          (it "'//[><]\n1><3' -> 4"
              (should= 4 (add "//[><]\n1><3")))
          (it "'//[>][<]\n1>2<3' -> 6"
              (should= 6 (add "//[>][<]\n1>2<3")))
          (it "'//[>][>>]\n1>2<3' -> 6"
              (should= 6 (add "//[>][>>]\n1>2>>3")))
          )

(run-specs)