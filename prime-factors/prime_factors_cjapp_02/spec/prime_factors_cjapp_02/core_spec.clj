(ns prime-factors-cjapp-02.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-02.core :refer :all]))

(describe "factors-of"
          (it "1 -> []"
              (should= [] (factors-of 1)))
          (it "2 -> [2]"
              (should= [2] (factors-of 2)))
          (it "3 -> [3]"
              (should= [3] (factors-of 3)))
          (it "4 -> [2 2]"
              (should= [2 2] (factors-of 4)))
          (it "5 -> [5]"
              (should= [5] (factors-of 5)))
          )

(run-specs)