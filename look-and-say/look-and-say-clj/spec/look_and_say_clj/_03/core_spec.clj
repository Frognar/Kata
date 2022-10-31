(ns look-and-say-clj._03.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._03.core :refer :all]))

(describe "Test"
          (it "should fail"
              (should= 1 0))
          )

(run-specs)
