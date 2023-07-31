(ns problem60)

;; problem 60 - Sequence Reductions
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-60/

;; (= (take 5 (__ + (range))) [0 1 3 6 10])
;; (= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
;; (= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)

(defn sequance-reductions
  ([f x]
   (->> (rest x)
        (sequance-reductions f (first x))))

  ([f value col]
   (if (empty? col) (list value)
       (->> (rest col)
            (sequance-reductions f (f value (first col)))
            (lazy-seq)
            (cons value)))))


(= (take 5 (sequance-reductions + (range))) [0 1 3 6 10])
(= (sequance-reductions conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])
(= (last (sequance-reductions * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)
