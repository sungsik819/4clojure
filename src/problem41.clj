(ns problem41)

;; problem 41 - Drop Every Nth Item
;; blug-url : https://sungsik819.github.io/posts/2019-11-13-4clojure-41.html

;; (= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
;; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
;; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])


;; keep-indexed
(defn my-dropitem [x y]
  (keep-indexed #(if (not= (mod (+ %1 1) y) 0) %2) x))

(= (my-dropitem [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (my-dropitem [:a :b :c :d :e :f] 2) [:a :c :e])
(= (my-dropitem [1 2 3 4 5 6] 4) [1 2 3 5 6])

;; partition-all 사용
(defn my-dropitem2 [coll x]
  (->> (partition-all (dec x) x coll)
       (apply concat)))

(= (my-dropitem2 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (my-dropitem2 [:a :b :c :d :e :f] 2) [:a :c :e])
(= (my-dropitem2 [1 2 3 4 5 6] 4) [1 2 3 5 6])

;; remove 사용
(defn my-dropitem3 [coll x]
  (->> (take (count coll) (iterate inc 1))
       (map list coll)
       (remove (fn [[_ k]] (= 0 (mod k x))))
       (map (fn [[v _]] v))))

(= (my-dropitem3 [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= (my-dropitem3 [:a :b :c :d :e :f] 2) [:a :c :e])
(= (my-dropitem3 [1 2 3 4 5 6] 4) [1 2 3 5 6])

  