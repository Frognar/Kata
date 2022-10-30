(ns look-and-say-clj.-02.core-spec
  (:require [speclj.core :refer :all]))

(describe "test"
          (it "should fail"
              (should= 0 1))
          )

(run-specs)