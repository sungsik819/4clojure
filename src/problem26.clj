(ns problem26)

;; problem 26 - Fibonacci Sequence
;; blog-url : https://sungsik819.github.io/posts/2019-10-29-4clojure-26.html

;; (= (__ 3) '(1 1 2))
;; (= (__ 6) '(1 1 2 3 5 8))
;; (= (__ 8) '(1 1 2 3 5 8 13 21))
(fn [x]
  (loop [li [1 1] cnt 2]
    (if (= cnt x) li
        (recur (conj li (+ (last li) (last (take (- (count li) 1) li)))) (+ cnt 1)))))

;; iterate
;; 이전의 [f s]값을 이용하는 iterate 성질을 이용하여 반복하도록 구현됨
(= (#(map (fn [[x _]] x)
         (take % 
               (iterate 
                (fn [[f s]] [s (+ f s)]) 
                [1 1]))) 3) '(1 1 2))

(= (#(map (fn [[x _]] x)
          (take %
                (iterate
                 (fn [[f s]] [s (+ f s)])
                 [1 1]))) 6) '(1 1 2 3 5 8))

(= (#(map (fn [[x _]] x)
          (take %
                (iterate
                 (fn [[f s]] [s (+ f s)])
                 [1 1]))) 8) '(1 1 2 3 5 8 13 21))
