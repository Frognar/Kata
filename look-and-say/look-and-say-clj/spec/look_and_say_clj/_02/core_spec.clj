(ns look-and-say-clj._02.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._02.core :refer :all]))

(describe "Look and say"
          (it "'1' -> '11'"
              (should= "11" (look-and-say "1")))
          )

(run-specs)