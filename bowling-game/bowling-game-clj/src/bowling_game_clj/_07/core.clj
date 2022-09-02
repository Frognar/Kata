(ns bowling-game-clj._07.core)

(defn ->frames [rolls]
  (if (empty? rolls)
    []
    (cons (take 2 rolls) (->frames (drop 2 rolls)))))

(defn score [rolls]
  (->> rolls (apply +)))
