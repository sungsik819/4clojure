(ns problem31)

;; problem 31 - Pack a Sequence
;; blog-url : https://sungsik819.github.io/posts/2019-11-03-4clojure-31.html

;; (= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
;; (= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
;; (= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

(= (partition-by list [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (partition-by list [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (partition-by list [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))