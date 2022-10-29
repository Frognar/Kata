(ns look-and-say-clj.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj.core :refer :all]))

(describe "Look and say"
          (it "'1' -> '11'"
              (should= "11" (look-and-say "1")))
          (it "'11' -> '21'"
              (should= "21" (look-and-say "11")))
          (it "'21' -> '1211'"
              (should= "1211" (look-and-say "21")))
          (it "'1211' -> '111221'"
              (should= "111221" (look-and-say "1211")))
          (it "'111221' -> '312211'"
              (should= "312211" (look-and-say "111221")))
          )

(describe "Look and say sequence"
          (it "'1', 0 -> '1'"
              (should= "1" (look-and-say-sequence "1" 0)))
          (it "'1', 1 -> '1:11'"
              (should= "1:11" (look-and-say-sequence "1" 1)))
          (it "'1', 2 -> '1:11:21'"
              (should= "1:11:21" (look-and-say-sequence "1" 2)))
          (it "'1', 7 -> '1:11:21:1211:111221:312211:13112221:1113213211'"
              (should= "1:11:21:1211:111221:312211:13112221:1113213211" (look-and-say-sequence "1" 7)))
          )

(run-specs)
