(ns prime-factors-cjapp-01.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-01.core :refer :all]))


(describe "factors of"
          (it "should be [] for 1"
              (should= [] (factors-of 1))
              )
          )

(run-specs)