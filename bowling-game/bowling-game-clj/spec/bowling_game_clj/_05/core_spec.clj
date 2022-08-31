(ns bowling-game-clj._05.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._05.core :refer :all]))

(describe "The Bowling Game"
          (it "should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "should score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          (it "should score spare"
              (should= 28 (score [5 5 9 0])))
          (it "should score strike"
              (should= 28 (score [10 5 4])))
          (it "should score 300 for perfect game"
              (should= 300 (score (repeat 12 10))))
          )

(describe "Frame Partitioning"
          (it "should partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          (it "should partition spare frames"
              (should= [[5 5 9] [9 0]] (->frames [5 5 9 0])))
          (it "should partition strike frames"
              (should= [[10 5 4] [5 4] [0 0]] (->frames [10 5 4 0 0])))
          )

(run-specs)
