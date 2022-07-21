(ns prime-factors-cjapp-06.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-06.core :refer :all]))

(describe "factors-of"
          (it "1->[]"
              (should= [] (factors-of 1)))
          )

(run-specs)