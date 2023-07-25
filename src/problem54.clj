(ns problem54)

;; problem 54 - Partition a Sequence
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-54/

;; (= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
;; (= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
;; (= (__ 3 (range 8)) '((0 1 2) (3 4 5)))

(defn partition-sequence [x coll]
  (loop [result [] coll2 coll]
    (if (or (empty? coll2) (> x (count coll2))) result
        (recur (conj result (take x coll2)) (drop x coll2)))))

(= (partition-sequence 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))
(= (partition-sequence 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))
(= (partition-sequence 3 (range 8)) '((0 1 2) (3 4 5)))