(ns clojure-kata.core)

;Const
(def n-disp 
  "Displacement of neighbour cells"
  (for [x (range -1 2) y (range -1 2) :when (not= [x y] [0 0])] [x y])) 

;Helper
(defn add [p1 p2] (map + p1 p2))

(defn neighbour
  "All neighbours of a cell" 
  [px] (map (partial add px) n-disp))

(defn num-neighbour 
  "Number of live neighbour for given cell in a grid"
  [grid px] (count (filter (partial contains? grid) (neighbour px))))

(defn live-on? [n-live] (<= 2 n-live 3))
(defn reproduce? [n-live] (= n-live 3))

(defn cell? [live n-live] 
  (if live 
    (live-on? n-live) 
    (reproduce? n-live)))

(def initial-grid #{[0 0] [0 1] [1 0] [1 1]})

