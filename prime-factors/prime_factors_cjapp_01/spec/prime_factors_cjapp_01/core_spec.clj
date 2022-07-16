(ns prime-factors-cjapp-01.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-01.core :refer :all]))


(describe "factors of"
          (it "should return prime factors of n"
              (should= [] (factors-of 1))
              (should= [2] (factors-of 2))
              (should= [3] (factors-of 3))
              (should= [2 2] (factors-of 4))
              )
          )

(run-specs)