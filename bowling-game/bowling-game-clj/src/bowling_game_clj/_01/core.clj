(ns bowling-game-clj._01.core)

(defn score [rolls]
  (->> rolls (apply +)))
