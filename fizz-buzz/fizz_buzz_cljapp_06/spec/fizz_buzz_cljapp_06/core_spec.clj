(ns fizz-buzz-cljapp-06.core-spec
  (:require [speclj.core :refer :all]
            [fizz-buzz-cljapp-06.core :refer :all]))

(describe "fizz buzz"
  (it "1 -> '1'"
    (should= "1" (fizz-buzz 1))))

(run-specs)
