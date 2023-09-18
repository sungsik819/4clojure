(ns problem11)

;; problem 11 - Maps: conj
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-11/

;; (= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))
(= {:a 1, :b 2, :c 3} (conj {:a 1} [:b 2] [:c 3]))