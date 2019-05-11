(ns clojure-kata.prime)

(defn divide? [x y] (zero? (mod x y)))

(defn prime?
  ([n primes-before] (not-any? #(divide? n %) primes-before)))

(defn next-prime
  ([primes] (let [start-with (or (peek primes) 2)]
              (first (filter #(prime? % primes) (iterate inc start-with))))))

(defn primes
  ([] (primes []))
  ([primes-before]
   (lazy-seq
     (let [new-prime (next-prime primes-before)
           new-primes-before (conj primes-before new-prime)]
       (cons new-prime (primes new-primes-before))))))

; => (take 10 (drop 200 (primes)))
; (1229 1231 1237 1249 1259 1277 1279 1283 1289 1291)
