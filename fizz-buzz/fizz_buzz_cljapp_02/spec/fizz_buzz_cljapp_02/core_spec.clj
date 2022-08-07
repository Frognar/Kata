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
          (it "6 -> true"
              (should= true (fizz? 6)))
          )

(describe "buzz?"
          (it "1 -> false"
              (should= false (buzz? 1)))
          (it "5 -> true"
              (should= true (buzz? 5)))
          (it "6 -> false"
              (should= false (buzz? 6)))
          (it "10 -> true"
              (should= true (buzz? 10)))
          )

(describe "fizzbuzz?"
          (it "3 -> false"
              (should= false (fizzbuzz? 3)))
          (it "5 -> false"
              (should= false (fizzbuzz? 5)))
          )

(run-specs)
