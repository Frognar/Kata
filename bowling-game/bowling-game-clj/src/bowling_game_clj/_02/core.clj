(ns bowling-game-clj._02.core)

(defn partition-frames [rolls]
  (partition 2 rolls))

(defn score [rolls]
  (->> rolls (apply +)))
