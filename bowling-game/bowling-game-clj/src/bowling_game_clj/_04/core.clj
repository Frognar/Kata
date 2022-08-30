(ns bowling-game-clj._04.core)

(defn split-frame [rolls]
  (if
    (= 10 (+ (first rolls) (second rolls)))
    [(take 3 rolls) (drop 2 rolls)]
    [(take 2 rolls) (drop 2 rolls)])
  )

(defn ->frames [rolls]
  (if
    (empty? rolls)
    []
    (let [[frame remaining] (split-frame rolls)]
      (cons frame (->frames remaining)))
    ))

(defn score [rolls]
  (->> rolls (apply +)))
