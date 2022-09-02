(ns bowling-game-clj._07.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._07.core :refer :all]))

(describe "The Bowling Game"
          (it "Should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          )

(run-specs)
