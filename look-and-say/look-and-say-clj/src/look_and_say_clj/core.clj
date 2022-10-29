(ns look-and-say-clj.core)

(defn look-and-say [input]
  (loop [res []
         [current & input] input
         dig_count 1]
    (if (not (nil? input))
      (if (= current (first input))
        (recur res input (inc dig_count))
        (recur (conj res (str dig_count current)) input 1))
      (str (apply str res) dig_count current))))

(defn look-and-say-sequence [input depth]
  (loop [res [input]
         current input
         depth depth]
    (if (> depth 0)
      (let [current (look-and-say current)]
        (recur (conj res (str ":" current)) current (dec depth)))
      (str (apply str res)))))