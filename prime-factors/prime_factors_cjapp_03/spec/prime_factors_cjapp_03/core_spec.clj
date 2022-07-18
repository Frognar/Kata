(ns prime-factors-cjapp-03.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-03.core :refer :all]))

(describe "factors of"
  (it "1 -> []"
    (should= [] (factors-of 1))))

(run-specs)