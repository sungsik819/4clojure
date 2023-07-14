(ns problem44)

;; problem 44 - Rotate Sequence
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-44/

;; (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
;; (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
;; (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
;; (= (__ 1 '(:a :b :c)) '(:b :c :a))
;; (= (__ -4 '(:a :b :c)) '(:c :a :b))

(defn rotate-sequence [n coll]
    (let [m (mod n (count coll))]
      (concat (drop m coll) (take m coll))))

(rotate-sequence 2 [1 2 3 4 5])
(rotate-sequence -2 [1 2 3 4 5])
(rotate-sequence 6 [1 2 3 4 5])
(rotate-sequence 1 [1 2 3 4 5])
(rotate-sequence -4 [1 2 3 4 5])


