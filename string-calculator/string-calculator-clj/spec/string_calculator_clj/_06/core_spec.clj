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
          (it "'8\n16' -> 22"
              (should= 22 (add "6\n16")))
          (it "'-32' -> throw exception"
              (should-throw (add "-32")))
          (it "'//>\n64>128' -> 192"
              (should= 192 (add "//>\n64>128")))
          (it "'//[>]\n256>512' -> 768"
              (should= 768 (add "//[>]\n256>512")))
          (it "'//[>][<]\n1024>2048<4096' -> 7168"
              (should= 7168 (add "//[>][<]\n1024>2048<4096")))
          (it "'//[>][>>]\n8192>16384>>32768' -> 352262"
              (should= 352262 (add "//[>][>>]\n8192>16384>>327686")))
          )

(run-specs)
