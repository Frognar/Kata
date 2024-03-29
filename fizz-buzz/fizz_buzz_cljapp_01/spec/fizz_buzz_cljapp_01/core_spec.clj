(ns fizz-buzz-cljapp-01.core-spec
  (:require [speclj.core :refer :all]
            [fizz-buzz-cljapp-01.core :refer :all]))

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
          )

(defn test-renderer
  [n]
  (str "__" n "__"))

(describe "renderer"
          (it "display each number"
              (should= ["__1__"] (render 1 test-renderer))
              (should= ["__1__", "__2__"] (render 2 test-renderer))
              )
          )


(run-specs)
