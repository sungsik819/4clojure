(ns problem57)

;; problem 57 - Simple Recursion
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-57/

;; (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

(= '(5 4 3 2 1) ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))

