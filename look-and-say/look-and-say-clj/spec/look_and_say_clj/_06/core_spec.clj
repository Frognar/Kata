(ns look-and-say-clj._06.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._06.core :refer :all]))

(describe "Test"
          (it "Should fail"
              (should= 1 0))
          )

(run-specs)
