(ns bowling-game-clj._03.core)

(defn is-strike? [[first & rolls]] (= 10 first))
(defn is-spare? [[first second & _]] (= 10 (+ first second)))

(defn split-frame [rolls]
  (cond
    (is-strike? rolls) [(take 3 rolls) (drop 1 rolls)]
    (is-spare? rolls) [(take 3 rolls) (drop 2 rolls)]
    :else [(take 2 rolls) (drop 2 rolls)]))

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining] (split-frame rolls)]
      (cons frame (->frames remaining)))
    )
  )

(defn score [rolls]
  (->> rolls ->frames flatten (apply +)))
