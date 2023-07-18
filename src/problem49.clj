(ns problem49)

;; problem 49 - Split a sequence
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-49/

;; (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
;; (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
;; (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])

(defn my-split-at [n l]
  (list (take n l) (drop n l)))