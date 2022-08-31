(ns bowling-game-clj._05.core)

(defn score [rolls]
  (->> rolls (apply +)))
