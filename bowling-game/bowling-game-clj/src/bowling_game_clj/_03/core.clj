(ns bowling-game-clj._03.core)

(defn is-spare? [rolls] (= 10 (+ (first rolls) (second rolls))))

(defn split-frame [rolls]
  (if (is-spare? rolls)
    [(take 3 rolls) (drop 2 rolls)]
    [(take 2 rolls) (drop 2 rolls)]))

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining] (split-frame rolls)]
      (cons frame (->frames remaining)))
    )
  )

(defn score [rolls]
  (->> rolls (apply +)))
