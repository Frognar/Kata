(ns bowling-game-clj._05.core)

(defn split-frames [rolls]
  [(take 2 rolls) (drop 2 rolls)])

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining] (split-frames rolls)]
      (cons frame (->frames remaining)))
    )
  )

(defn score [rolls]
  (->> rolls (apply +)))
