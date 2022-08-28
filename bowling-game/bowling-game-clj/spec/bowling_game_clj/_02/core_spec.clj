(ns bowling-game-clj._02.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._02.core :refer :all]))

(describe "The Bowling Game"
          (it "score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          )

(describe "Frame partitioning"
          (it "partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          (it "partition spare frames"
              (should= [[5 5 3] [3 4]] (->frames [5 5 3 4])))
          )

(run-specs)
