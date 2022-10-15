(ns problem24)

;; problem 24 - Sum It All Up
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-24/

;; (= (__ [1 2 3]) 6)
;; (= (__ (list 0 -2 5 5)) 8)
;; (= (__ #{4 2 1}) 7)
;; (= (__ '(0 0 -1)) -1)
;; (= (__ '(1 10 3)) 14)

;; apply
(= (#(apply + %) [1 2 3]) 6)
(= (#(apply + %) (list 0 -2 5 5)) 8)
(= (#(apply + %) #{4 2 1}) 7)
(= (#(apply + %) '(0 0 -1)) -1)
(= (#(apply + %) '(1 10 3)) 14)

;; reduce
(= (#(reduce + %) [1 2 3]) 6)
(= (#(reduce + %) (list 0 -2 5 5)) 8)
(= (#(reduce + %) #{4 2 1}) 7)
(= (#(reduce + %) '(0 0 -1)) -1)
(= (#(reduce + %) '(1 10 3)) 14)


;; other - loop recur
(defn my-sum [x]
  (loop [result 0 coll x]
    (if (empty? coll) result
        (recur (+ result (first coll)) (rest coll)))))

(= (#(my-sum %) [1 2 3]) 6)
(= (#(my-sum %) (list 0 -2 5 5)) 8)
(= (#(my-sum %) #{4 2 1}) 7)
(= (#(my-sum %) '(0 0 -1)) -1)
(= (#(my-sum %) '(1 10 3)) 14)