(ns look-and-say-clj.core)

(defn look-and-say [input]
  (loop [res []
         input input
         dig_count 1]
    (if (> (count input) 1)
        (if (= (first input) (second input))
          (recur res (subs input 1) (inc dig_count))
          (recur (conj res (str dig_count (first input))) (subs input 1) dig_count))
      (str (apply str res) dig_count input))))