(ns problem18)

;; problem 18 - Sequences: filter
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-18/

;; (= __ (filter #(> % 5) '(3 4 5 6 7)))

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))
