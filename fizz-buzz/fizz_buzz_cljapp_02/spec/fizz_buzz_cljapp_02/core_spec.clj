(ns fizz-buzz-cljapp-02.core-spec
  (:require [speclj.core :refer :all]
            [fizz-buzz-cljapp-02.core :refer :all]))

(describe "fizz?"
          (it "1 -> false"
              (should= false (fizz? 1)))
          (it "2 -> false"
              (should= false (fizz? 2)))
          )

(run-specs)
