(ns bowling-game-clj._07.core)

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (let [frame (take 2 rolls)] (cons frame (->frames (drop 2 rolls))))
    ))

(defn score [rolls]
  (->> rolls (apply +)))
