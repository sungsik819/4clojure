(ns problem21)

;; problem 21 - Nth Element
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-21/

;; (= (__ '(4 5 6 7) 2) 6)
;; (= (__ [:a :b :c] 0) :a)
;; (= (__ [1 2 3 4] 1) 2)
;; (= (__ '([1 2] [3 4] [5 6]) 2) [5 6])

(= (#(first (drop %2 %1)) '(4 5 6 7) 2) 6)
(= (#(first (drop %2 %1)) [:a :b :c] 0) :a)
(= (#(first (drop %2 %1)) [1 2 3 4] 1) 2)
(= (#(first (drop %2 %1)) '([1 2] [3 4] [5 6]) 2) [5 6])

;; other
;; recur을 사용하여 %2가 0이 될때까지 rest로 잘라내어 값을 가져온다
;; #(if (= %2 0) (first %1) (recur (rest %1) (- %2 1)))
(= (#(if (= %2 0) (first %1) (recur (rest %1) (- %2 1))) '(4 5 6 7) 2) 6)
(= (#(if (= %2 0) (first %1) (recur (rest %1) (- %2 1))) [:a :b :c] 0) :a)
(= (#(if (= %2 0) (first %1) (recur (rest %1) (- %2 1))) [1 2 3 4] 1) 2)
(= (#(if (= %2 0) (first %1) (recur (rest %1) (- %2 1))) '([1 2] [3 4] [5 6]) 2) [5 6])

;; other 2
;; reduce
;; 아무런 조건이 없으면 마지막 값을 리턴하는 reduce의 기능을 이용,
;; reverse, drop으로 원하는 값을 마지막에 위치 시킨다.
;; #(reduce (fn [_ x] x) (reverse (drop %2 %1)))
(= (#(reduce (fn [_ x] x) (reverse (drop %2 %1))) '(4 5 6 7) 2) 6)
(= (#(reduce (fn [_ x] x) (reverse (drop %2 %1))) [:a :b :c] 0) :a)
(= (#(reduce (fn [_ x] x) (reverse (drop %2 %1))) [1 2 3 4] 1) 2)
(= (#(reduce (fn [_ x] x) (reverse (drop %2 %1))) '([1 2] [3 4] [5 6]) 2) [5 6])