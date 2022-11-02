(ns look-and-say-clj._05.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._05.core :refer :all]))

(describe "test"
          (it "should fail"
              (should= 1 0))
          )

(run-specs)
