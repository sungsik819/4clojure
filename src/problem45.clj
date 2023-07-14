(ns problem45)

;; problem 45 - Intro to Iterate
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-45/

;; (= __ (take 5 (iterate #(+ 3 %) 1)))

(= [1 4 7 10 13] (take 5 (iterate #(+ 3 %) 1)))