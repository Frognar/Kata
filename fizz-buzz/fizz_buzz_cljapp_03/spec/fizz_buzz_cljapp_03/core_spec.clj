(ns fizz-buzz-cljapp-03.core-spec
  (:require [speclj.core :refer :all]
            [fizz-buzz-cljapp-03.core :refer :all]))

(describe "fizz buzz"
          (it "1 -> '1'"
              (should= "1" (fizz-buzz 1)))
          (it "2 -> '2'"
              (should= "2" (fizz-buzz 2)))
          (it "3 -> 'Fizz'"
              (should= "Fizz" (fizz-buzz 3)))
          (it "4 -> '4'"
              (should= "4" (fizz-buzz 4)))
          (it "5 -> 'Buzz'"
              (should= "Buzz" (fizz-buzz 5)))
          (it "6 -> 'Fizz'"
              (should= "Fizz" (fizz-buzz 6)))
          (it "10 -> 'Buzz'"
              (should= "Buzz" (fizz-buzz 10)))
          (it "15 -> 'FizzBuzz'"
              (should= "FizzBuzz" (fizz-buzz 15)))
          (it "30 -> 'FizzBuzz'"
              (should= "FizzBuzz" (fizz-buzz 30)))
          )

(describe "render"
          (let [r (fn [n] (str "-" n "-")) ]
            (it "1 -> ['-1-']"
                (should= ["-1-"] (render 1 r)))
            ))

(run-specs)
