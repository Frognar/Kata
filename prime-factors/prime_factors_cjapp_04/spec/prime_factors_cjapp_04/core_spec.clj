(ns prime-factors-cjapp-04.core-spec
  (:require [speclj.core :refer :all]
            [prime-factors-cjapp-04.core :refer :all]))

(describe "factors of"
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
          (it "6 -> [2 3]"
              (should= [2 3] (factors-of 6)))
          (it "7 -> [7]"
              (should= [7] (factors-of 7)))
          (it "8 -> [2 2 2]"
              (should= [2 2 2] (factors-of 8)))
          (it "9 -> [3 3]"
              (should= [3 3] (factors-of 9)))
          (it "2*2*3*3*11*11*17 -> [2 2 3 3 11 11 17]"
              (should= [2 2 3 3 11 11 17] (factors-of (* 2 2 3 3 11 11 17))))
          (it "2^31-1 -> [2^31-1]"
              (let [m31 (dec (apply * (repeat 31 2)))]
                (should= [m31] (factors-of m31))))
          (it "2^61-1 -> [2^61-1]"
              (let [m61 (dec (apply * (repeat 61 2)))]
                (should= [m61] (factors-of m61))))
          )

(run-specs)