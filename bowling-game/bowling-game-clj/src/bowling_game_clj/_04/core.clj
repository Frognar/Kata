(ns bowling-game-clj._04.core)

(defn is-spare? [[first second & _]] (= 10 (+ first second)))

(defn split-frame [rolls]
  (cond
    (is-spare? rolls) [(take 3 rolls) (drop 2 rolls)]
    :else [(take 2 rolls) (drop 2 rolls)])
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
