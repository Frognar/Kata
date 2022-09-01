(ns bowling-game-clj._06.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._06.core :refer :all]))

(describe "The Bowling Game"
          (it "Should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "Should score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          ;(it "Should score spare"
          ;    (should= 20 (score [5 5 4 2])))
          )

(describe "Frame Partitioning"
          (it "Should partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          (it "Should partition spare frames"
              (should= [[5 5 4] [4 2]] (->frames [5 5 4 2])))
          )

(run-specs)
