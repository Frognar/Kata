(ns bowling-game-clj._05.core)

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (cons (take 2 rolls) (->frames (drop 2 rolls)))
    )
  )

(defn score [rolls]
  (->> rolls (apply +)))
