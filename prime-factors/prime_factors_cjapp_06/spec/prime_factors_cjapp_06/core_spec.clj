(ns prime-factors-cjapp-06.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-06.core :refer :all]))

(describe "factors-of"
          (it "1->[]"
              (should= [] (factors-of 1)))
          (it "2->[2]"
              (should= [2] (factors-of 2)))
          )

(run-specs)