(ns bowling-game-clj._01.core)

(defn is-spare? [rolls] (= 10 (apply + (take 2 rolls))))

(defn split-frame [rolls]
  (cond
    (= 10 (first rolls)) [(take 3 rolls) (drop 1 rolls)]
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
  (->> rolls ->frames flatten (apply +)))
