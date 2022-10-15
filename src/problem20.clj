(ns problem20)

;; problem 20 - Penultimate Element
;; blug-url: https://sungsik819.github.io/posts/4clojure/problem-20/

;; (= (__ (list 1 2 3 4 5)) 4)
;; (= (__ ["a" "b" "c"]) "b")
;; (= (__ [[1 2] [3 4]]) [1 2])

(= (#(second (reverse %)) (list 1 2 3 4 5)) 4)
(= (#(second (reverse %)) ["a" "b" "c"]) "b")
(= (#(second (reverse %)) [[1 2] [3 4]]) [1 2])