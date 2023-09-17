(ns problem10)

;; problem 10 - Intro to Maps
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-10/

;; (= __ ((hash-map :a 10, :b 20, :c 30) :b))
;; (= __ (:b {:a 10, :b 20, :c 30}))

(= 20 ((hash-map :a 10, :b 20, :c 30) :b))
(= 20 (:b {:a 10, :b 20, :c 30}))