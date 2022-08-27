(ns bowling-game-clj._01.core)

(defn is-strike? [rolls] (= 10 (first rolls)))
(defn is-spare? [rolls] (= 10 (apply + (take 2 rolls))))

(defn split-frame [rolls]
  (cond
    (is-strike? rolls) [(take 3 rolls) (rest rolls)]
    (is-spare? rolls) [(take 3 rolls) (drop 2 rolls)]
    :else [(take 2 rolls) (drop 2 rolls)])
  )

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining]
          (split-frame rolls)]
      (cons frame (->frames remaining)))))

(defn score [rolls]
  (->> rolls ->frames (take 10) flatten (apply +)))
