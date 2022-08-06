(ns fizz-buzz-cljapp-01.core-spec
  (:require [speclj.core :refer :all]
            [fizz-buzz-cljapp-01.core :refer :all]))

(describe "fizz buzz"
          (it "1 -> '1'"
              (should= "1" (fizz-buzz 1)))
          (it "2 -> '2'"
              (should= "2" (fizz-buzz 2)))
          )

(run-specs)
