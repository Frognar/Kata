(ns bowling-game-clj._06.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._06.core :refer :all]))

(describe "The Bowling Game"
          (it "Should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          (it "Should score 20 for all ones"
              (should= 20 (score (repeat 20 1))))
          )

(run-specs)
