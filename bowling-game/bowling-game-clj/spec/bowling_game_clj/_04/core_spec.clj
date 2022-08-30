(ns bowling-game-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._04.core :refer :all]))

(describe "The Bowling Game"
          (it "score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          ;(it "score a spare"
          ;    (should= 24 (score [5 5 5 4])))
          )

(describe "Frame partitioning"
          (it "partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          )

(run-specs)
