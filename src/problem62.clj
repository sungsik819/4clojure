(ns problem62)

;; problem 62 - Re-implement Iterate
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-62/

;; (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
;; (= (take 100 (__ inc 0)) (take 100 (range)))
;; (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))

(defn iter [f x]
  (->> (f x)
       (iter f)
       (cons x)
       (lazy-seq)))

(= (take 5 (iter #(* 2 %) 1)) [1 2 4 8 16])
(= (take 100 (iter inc 0)) (take 100 (range)))
(= (take 9 (iter #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))