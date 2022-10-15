(ns problem23)

;; problem 23 - Reverse a Sequence
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-23/

;; (= (__ [1 2 3 4 5]) [5 4 3 2 1])
;; (= (__ (sorted-set 5 7 2 7)) '(7 5 2))
;; (= (__ [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

;; reduce
;; reduce와 conj의 특성을 조합하여 reverse 한다.
(= (#(reduce (fn [acc e] (conj acc e)) '() %) [1 2 3 4 5]) [5 4 3 2 1])
(= (#(reduce (fn [acc e] (conj acc e)) '() %) (sorted-set 5 7 2 7)) '(7 5 2))
(= (#(reduce (fn [acc e] (conj acc e)) '() %) [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])

;; into
(= (#(into '() %) [1 2 3 4 5]) [5 4 3 2 1])
(= (#(into '() %) (sorted-set 5 7 2 7)) '(7 5 2))
(= (#(into '() %) [[1 2] [3 4] [5 6]]) [[5 6] [3 4] [1 2]])