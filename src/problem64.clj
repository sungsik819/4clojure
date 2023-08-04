(ns problem64)

;; problem 64 - Intro to Reduce
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-64/

;; (= 15 (reduce __ [1 2 3 4 5]))
;; (=  0 (reduce __ []))
;; (=  6 (reduce __ 1 [2 3]))

(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))