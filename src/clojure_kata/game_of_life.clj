(ns clojure-kata.game-of-life
  (:require [clojure.set :refer :all]))

(def neighbour-offsets (for [x [-1 0 1] y [-1 0 1] :when (not= [x y] [0 0])] [x y] ))

(defn add [p1 p2] (vec (map + p1 p2)))
(defn neighbours [p] (map #(add p %) neighbour-offsets) )

(defn live-neighbours [grid p] (count (filter #(contains? grid %) (neighbours p)) ))

(defn live? [p-live live-neighbours] (if p-live
                                       (<= 2 live-neighbours 3) ; Any live cell with two or three live neighbours lives on to the next generation
                                       (= 3 live-neighbours))) ; Any dead cell with three live neighbours becomes a live cell

(defn next-state
  [grid]
  (let [points (union grid (mapcat neighbours grid))]
    (set
     (filter #(live? (contains? grid %) (live-neighbours grid %)) points))))

(defn game-of-life
  [grid]
  (lazy-seq (cons grid (game-of-life (next-state grid)))))
