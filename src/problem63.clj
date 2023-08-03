(ns problem63)

;; problem 63 - Group a Sequence
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-63/

;; (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})

;; (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
;;   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})

;; (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])
;;   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

(defn group-sequence [f coll]
  (->> (sort coll)
       (partition-by f)
       (map #(vector (f (first %)) (vec %)))
       (into {})))

(= (group-sequence #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
(= (group-sequence #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
(= (group-sequence count [[1] [1 2] [3] [1 2 3] [2 3]])
   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})
