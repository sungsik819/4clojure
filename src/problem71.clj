(ns problem71)

;; problem 71 - Rearranging Code: ->
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-71/

;; (= (__ (sort (rest (reverse [2 5 4 1 3 6]))))
;;    (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (__))
;;    5)

(= (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] (reverse) (rest) (sort) (last))
   5)