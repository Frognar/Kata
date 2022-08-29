(ns bowling-game-clj._03.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._03.core :refer :all]))

(describe "The Bowling Game"
          (it "score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          (it "score a spare"
              (should= 18 (score [5 5 4 0])))
          (it "score a strike"
              (should= 28 (score [10 5 4 0 0])))
          (it "score a perfect game"
              (should= 300 (score (repeat 12 10))))
          )

(describe "Partitioning frames"
          (it "partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          (it "partition spare frames"
              (should= [[5 5 3] [3 4]] (->frames [5 5 3 4])))
          (it "partition strike frames"
              (should= [[10 5 4] [5 4]] (->frames [10 5 4])))
          )

(run-specs)
