(ns bowling-game-clj._01.core)

(defn split-frame [rolls]
  [(take 2 rolls) (drop 2 rolls)])

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [[frame remaining]
          (split-frame rolls)]
      (cons frame (->frames remaining)))))

(defn score [rolls]
  (->> rolls (apply +)))
