(ns bowling-game-clj._05.core-spec
  (:require [speclj.core :refer :all]
            [bowling-game-clj._05.core :refer :all]))

(describe "The Bowling Game",
          (it "should score 0 for all zeros"
              (should= 0 (score (repeat 20 0))))
          )

(run-specs)
