(ns bowling-game-clj._06.core)

(defn score [rolls]
  (->> rolls (apply +)))
