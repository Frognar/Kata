(ns bowling-game-clj._03.core)

(defn ->frames [rolls]
  (partition 2 rolls))

(defn score [rolls]
  (->> rolls (apply +)))
