(ns problem37)

;; problem 37 - Regular Expressions
;; blug-url : https://sungsik819.github.io/posts/2019-11-09-4clojure-37.html

;; (= __ (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))

