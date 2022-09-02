(ns bowling-game-clj._07.core)

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining] [(take 2 rolls) (drop 2 rolls)]]
      (cons frame (->frames remaining)))
    ))

(defn score [rolls]
  (->> rolls (apply +)))
