(ns bowling-game-clj._05.core)

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (partition 2 rolls)
    )
  )

(defn score [rolls]
  (->> rolls (apply +)))
