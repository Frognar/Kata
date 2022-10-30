(ns look-and-say-clj._02.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._02.core :refer :all]))

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

(run-specs)