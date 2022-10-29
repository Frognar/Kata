(ns look-and-say-clj.core)

(defn look-and-say [input]
  (loop [res []
         input input
         dig_count 1]
    (if (> (count input) 1)
      (if (= (first input) (second input))
        (recur res (subs input 1) (inc dig_count))
        (recur (conj res (str dig_count (first input))) (subs input 1) 1))
      (str (apply str res) dig_count input))))

(defn look-and-say-sequence [input depth]
  (loop [res [input]
         current input
         depth depth]
    (if (> depth 0)
      (str (apply str res) ":" (look-and-say current))
      input)))