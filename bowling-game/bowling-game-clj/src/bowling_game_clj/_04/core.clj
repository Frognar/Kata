(ns bowling-game-clj._04.core)

(defn score [rolls]
  (->> rolls (apply +)))
