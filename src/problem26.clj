(ns problem26)

;; problem 26 - Fibonacci Sequence
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-26/

;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))
(defn fib1 [x]
  (loop [coll [1 1] cnt 2]
    (if (= cnt x) coll
        (recur (conj coll (+ (last coll) (last (take (- (count coll) 1) coll)))) (+ cnt 1)))))

(= (fib1 3) '(1 1 2))
(= (fib1 6) '(1 1 2 3 5 8))
(= (fib1 8) '(1 1 2 3 5 8 13 21))

;; iterate
;; 이전의 [f s]값을 이용하는 iterate 성질을 이용하여 반복하도록 구현됨

(defn fib2 [x]
  (->> (iterate (fn [[f s]] [s (+ f s)]) [1 1])
       (take x)
       (map (fn [[x _]] x))))

(= (fib2 3) '(1 1 2))
(= (fib2 6) '(1 1 2 3 5 8))
(= (fib2 8) '(1 1 2 3 5 8 13 21))