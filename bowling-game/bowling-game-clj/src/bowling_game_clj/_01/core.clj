(ns bowling-game-clj._01.core)

(defn ->frames [rolls]
  (partition 2 rolls))

(defn score [rolls]
  (->> rolls (apply +)))
