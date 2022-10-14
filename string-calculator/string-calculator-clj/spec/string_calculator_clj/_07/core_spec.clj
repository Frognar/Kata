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
          (it "'7\n9' -> 16"
              (should= 16 (add "7\n9")))
          (it "'-11' -> throw exception"
              (should-throw (add "-11")))
          (it "'999,1000,1001' -> 1999"
              (should= 1999 (add "999,1000,1001")))
          (it "'//>\n13>15' -> 28"
              (should= 28 (add "//>\n13>15")))
          (it "'//[>]\n17>19' -> 36"
              (should= 36 (add "//[>]\n17>19")))
          (it "'//[>][<]\n21>23<25' -> 69"
              (should= 69 (add "//[>][<]\n21>23<25")))
          )

(run-specs)
