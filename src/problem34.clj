(ns problem34)


;; problem 34 - Implement range
;; blug-url : https://sungsik819.github.io/posts/2019-11-06-4clojure-34.html

;; (= (__ 1 4) '(1 2 3))
;; (= (__ -2 2) '(-2 -1 0 1))
;; (= (__ 5 8) '(5 6 7))

(defn my-range [x y]
  (loop [coll [] cnt x]
    (if (= cnt y) (seq coll)
        (recur (conj coll cnt) (+ cnt 1)))))

(= (#(my-range %1 %2) 1 4) '(1 2 3))
(= (#(my-range %1 %2) -2 2) '(-2 -1 0 1))
(= (#(my-range %1 %2) 5 8) '(5 6 7))

;; other
(= (#(take (- %2 %) (iterate inc %)) 1 4) '(1 2 3))
(= (#(take (- %2 %) (iterate inc %)) -2 2) '(-2 -1 0 1))
(= (#(take (- %2 %) (iterate inc %)) 5 8) '(5 6 7))
