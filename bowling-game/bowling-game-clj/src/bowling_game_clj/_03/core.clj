(ns bowling-game-clj._03.core)

(defn score [rolls]
  (->> rolls (apply +)))
