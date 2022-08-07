(ns fizz-buzz-cljapp-02.core-spec
  (:require [speclj.core :refer :all]
            [fizz-buzz-cljapp-02.core :refer :all]))

(describe "fizz?"
          (it "1 -> false"
              (should= false (fizz? 1)))
          (it "2 -> false"
              (should= false (fizz? 2)))
          (it "3 -> true"
              (should= true (fizz? 3)))
          (it "4 -> false"
              (should= false (fizz? 4)))
          (it "5 -> false"
              (should= false (fizz? 5)))
          )

(run-specs)
