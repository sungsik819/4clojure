(ns problem53)

;; problem 53 - Longest Increasing Sub-Seq
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-53/

;; (= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])
;; (= (__ [5 6 1 3 2 7]) [5 6])
;; (= (__ [2 3 3 4 5]) [3 4 5])
;; (= (__ [7 6 5 4]) [])

(defn longest-incresing-sub-seq [coll] 
  (let [v (->> (rest coll)
               (reduce #(if (= (inc (last (last %))) %2) (conj % (conj (last %) %2)) (conj % [%2])) [[(first coll)]])
               (filter (fn [x] (> (count x) 1)))
               (sort)
               (last))]
    (if (nil? v) [] v)))

(= (longest-incresing-sub-seq [1 0 1 2 3 0 4 5]) [0 1 2 3])
(= (longest-incresing-sub-seq [5 6 1 3 2 7]) [5 6])
(= (longest-incresing-sub-seq [2 3 3 4 5]) [3 4 5])
(= (longest-incresing-sub-seq [7 6 5 4]) [])