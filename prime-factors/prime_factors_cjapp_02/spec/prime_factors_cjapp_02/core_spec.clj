(ns prime-factors-cjapp-02.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-02.core :refer :all]))

(describe "factors-of"
          (it "1 -> []"
              (should= [] (factors-of 1))))

(run-specs)