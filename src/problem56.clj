(ns problem56)

;; problem 56 - Find Distinct Items
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-56/

;; (= (__ [1 2 1 3 1 2 4]) [1 2 3 4])
;; (= (__ [:a :a :b :b :c :c]) [:a :b :c])
;; (= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
;; (= (__ (range 50)) (range 50))

(defn find-distinct-items [coll]
  (reduce (fn [acc num]
            (if (some true? (map #(= % num) acc)) acc
                (conj acc num))) [] coll))

(= (find-distinct-items [1 2 1 3 1 2 4]) [1 2 3 4])
(= (find-distinct-items [:a :a :b :b :c :c]) [:a :b :c])
(= (find-distinct-items '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (find-distinct-items (range 50)) (range 50))

(defn find-distinct-items2 [coll]
  (reduce #({%2 %} ((set %) %2) (conj % %2)) [] coll))

(= (find-distinct-items2 [1 2 1 3 1 2 4]) [1 2 3 4])
(= (find-distinct-items2 [:a :a :b :b :c :c]) [:a :b :c])
(= (find-distinct-items2 '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))
(= (find-distinct-items2 (range 50)) (range 50))