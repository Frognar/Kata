(ns bowling-game-clj._06.core)

(defn split-frames [rolls]
  (if (= 10 (+ (first rolls) (second rolls)))
    [(take 3 rolls) (drop 2 rolls)]
    [(take 2 rolls) (drop 2 rolls)]))

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining] (split-frames rolls)]
      (cons frame (->frames remaining)))
    )
  )

(defn score [rolls]
  (->> rolls (apply +)))
