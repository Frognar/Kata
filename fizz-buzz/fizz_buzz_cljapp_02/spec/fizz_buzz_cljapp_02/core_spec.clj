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
          (it "15 -> true"
              (should= true (fizzbuzz? 15)))
          (it "25 -> false"
              (should= false (fizzbuzz? 25)))
          (it "30 -> true"
              (should= true (fizzbuzz? 30)))
          )

(describe "fizzbuzz"
          (it "1 -> '1'"
              (should= "1" (fizzbuzz 1)))
          (it "2 -> '2'"
              (should= "2" (fizzbuzz 2)))
          (it "3 -> 'Fizz'"
              (should= "Fizz" (fizzbuzz 3)))
          (it "4 -> '4'"
              (should= "4" (fizzbuzz 4)))
          (it "5 -> 'Buzz'"
              (should= "Buzz" (fizzbuzz 5)))
          (it "6 -> 'Fizz'"
              (should= "Fizz" (fizzbuzz 6)))
          (it "10 -> 'Buzz'"
              (should= "Buzz" (fizzbuzz 10)))
          (it "15 -> 'FizzBuzz'"
              (should= "FizzBuzz" (fizzbuzz 15)))
          )

(describe "render"
          (let [r (fn [n] (str "_" n "_"))]
            (it "1 -> ['_1_']"
                (should= ["_1_"] (render 1 r))))
          )

(run-specs)
