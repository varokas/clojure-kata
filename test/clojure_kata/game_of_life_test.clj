(ns clojure-kata.game-of-life-test
  (:require [clojure.test :refer :all])
  (:require [clojure-kata.game-of-life :refer :all]))

(:use 'clojure.test)

; ....
; .XX.
; .XX.
; ....
(testing "still life"
  (let [box #{[0 0] [0 1] [1 0] [1 1]}]
    (every? #(is (= box %)) (take 10 (game-of-life box)))))

 ;.X.     ...
 ;.X. <=> XXX
 ;.X.     ...
(testing "Oscillators"
  (let [start #{[-1  0] [0 0] [1  0]}
        next  #{[ 0 -1] [0 0] [0  1]}
        states (take 10 (game-of-life start))]
    (testing "start states" (every? #(is (= start %)) (take-nth 2 states)))
    (testing "next states" (every? #(is (= next %)) (take-nth 2 (drop 1 states))))
    ))