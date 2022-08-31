(ns bowling-game-clj._05.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._05.core :refer :all]))

(describe "The Bowling Game"
          (it "should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "should score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          ;(it "should score spare"
          ;    (should= 28 (score [5 5 9 0])))
          )

(describe "Frame Partitioning"
          (it "should partition open frames"
              (should= [[1 2] [3 4]] (->frames [1 2 3 4])))
          )

(run-specs)
