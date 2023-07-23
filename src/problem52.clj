(ns problem52)

;; problem 52 - Intro to Destructuring
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-52/

;; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))

(= [2 4] (let [[a b c d e] [0 1 2 3 4]] [c e]))
