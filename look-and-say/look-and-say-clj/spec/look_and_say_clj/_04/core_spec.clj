(ns look-and-say-clj._04.core-spec
  (:require [speclj.core :refer :all]
            [look-and-say-clj._04.core :refer :all]))

(describe "TEST"
          (it "should fail"
              (should= 1 0)))

(run-specs)
