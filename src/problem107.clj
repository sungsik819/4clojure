(ns problem107)

;; problem 107 - Simple closures
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-107/

;; (= 256 ((__ 2) 16),
;;    ((__ 8) 2))

;; (= [1 8 27 64] (map (__ 3) [1 2 3 4]))

;; (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))

(defn simple-closure [x]
  (fn [y]
    (apply * (take x (iterate identity y)))))


(= 256 ((simple-closure 2) 16),
   ((simple-closure 8) 2))

(= [1 8 27 64] (map (simple-closure 3) [1 2 3 4]))

(= [1 2 4 8 16] (map #((simple-closure %) 2) [0 1 2 3 4]))