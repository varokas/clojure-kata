(ns clojure-kata.prime-test
  (:require [clojure.test :refer :all])
  (:require [clojure-kata.prime :refer :all]))

(:use 'clojure.test)

(testing "prime" (is (= '(2 3 5 7 11) (take 5 (primes)))))