(ns problem118)

;; problem 118 - Re-implement Map
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-118/

;; (= [3 4 5 6 7]
;;    (__ inc [2 3 4 5 6]))

;; (= (repeat 10 nil)
;;    (__ (fn [_] nil) (range 10)))

;; (= [1000000 1000001]
;;    (->> (__ inc (range))
;;         (drop (dec 1000000))
;;         (take 2)))

;; (= [1000000 1000001]
;;    (->> (__ inc (range))
;;         (drop (dec 1000000))
;;         (take 2)))

;; solved
(defn mymap [f coll]
 (if (seq coll) (lazy-seq (cons (f (first coll)) (mymap f (rest coll))))))
  

(= [3 4 5 6 7]
   (mymap inc [2 3 4 5 6]))

(= (repeat 10 nil)
   (mymap (fn [_] nil) (range 10)))

(= [1000000 1000001]
   (->> (mymap inc (range))
        (drop (dec 1000000))
        (take 2)))

(= [1000000 1000001]
   (->> (mymap inc (range))
        (drop (dec 1000000))
        (take 2)))