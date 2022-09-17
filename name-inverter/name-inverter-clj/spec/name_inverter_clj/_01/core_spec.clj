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
          (it "Should return 'last, first' when invert 'first last'"
              (should= "Lupercal, Horus" (invert "Horus Lupercal")))
          (it "Should return 'last, first' when invert 'first   last'"
              (should= "Lupercal, Horus" (invert "Horus   Lupercal")))
          (it "Should return 'last, first' when invert 'honorific first last'"
              (should= "Lupercal, Horus" (invert "Mr. Horus Lupercal"))
              (should= "Lupercal, Horus" (invert "Mrs. Horus Lupercal")))
          (it "Should return 'last, first postnominal' when invert 'first last postnominal'"
              (should= "Lupercal, Horus Sr." (invert "Horus Lupercal Sr.")))
          (it "Should return 'last, first postnominals' when invert 'first last postnominals'"
              (should= "Lupercal, Horus Sr. PhD." (invert "Horus Lupercal Sr. PhD.")))
          (it "Should return 'last, first postnominals' when invert '  honorifics  first   last   postnominals  '"
              (should= "Lupercal, Horus Sr. PhD." (invert "  Mr.  Horus   Lupercal   Sr.   PhD.  ")))
          )
