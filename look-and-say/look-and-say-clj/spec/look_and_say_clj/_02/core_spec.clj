(ns look-and-say-clj._02.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._02.core :refer :all]))

(describe "Look and say"
          (it "'1' -> '11'"
              (should= "11" (look-and-say "1")))
          (it "'11' -> '21'"
              (should= "21" (look-and-say "11")))
          )

(run-specs)