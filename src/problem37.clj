(ns problem37)

;; problem 37 - Regular Expressions
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-37/

;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

