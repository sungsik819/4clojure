(ns problem5)

;; problem 05 - conj on lists
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-05/

;; (= __ (conj '(2 3 4) 1))
;; (= __ (conj '(3 4) 2 1))

(= '(1 2 3 4) (conj '(2 3 4) 1))
(= '(1 2 3 4) (conj '(3 4) 2 1))
