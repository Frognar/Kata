(ns name-inverter-clj._01.core-spec
  (:require [speclj.core :refer :all]
            [name-inverter-clj._01.core :refer :all]))

(describe "Name Inverter"
          (it "Should throw exception when invert nil"
              (should-throw (invert nil)))
          (it "Should return empty when invert empty"
              (should= "" (invert "")))
          (it "Should return empty when invert whitespaces"
              (should= "" (invert "   ")))
          (it "Should return firstname when invert firstname"
              (should= "Horus" (invert "Horus")))
          )