(ns bowling-game-clj._02.core)

(defn score [rolls]
  (->> rolls (apply +)))
