(ns bowling-game-clj._07.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._07.core :refer :all]))

(describe "The Bowling Game"
          (it "Should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "Should score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          (it "Should score spare"
              (should= 18 (score [5 5 4 0])))
          ;(it "Should score strike"
          ;    (should= 28 (score [10 5 4])))
          )

(describe "Frame Partitioning"
          (it "Should partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          (it "Should partition spare frames"
              (should= [[5 5 4] [4 0]] (->frames [5 5 4 0])))
          (it "Should partition strike frames"
              (should= [[10 5 4] [5 4]] (->frames [10 5 4])))
          )

(run-specs)