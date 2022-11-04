(ns look-and-say-clj._07.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._07.core :refer :all]))

(describe "Test"
          (it "should fail"
              (should= 0 1))
          )

(run-specs)
