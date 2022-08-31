(ns bowling-game-clj._05.core)

(defn is-spare [[first second & _]] (= 10 (+ first second)))

(defn split-frames [rolls]
  (if (is-spare rolls)
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
  (->> rolls ->frames flatten (apply +)))
