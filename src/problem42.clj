(ns problem42)

;; problem 42 - Factorial Fun
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-42/

;; (= (__ 1) 1)
;; (= (__ 3) 6)
;; (= (__ 5) 120)
;; (= (__ 8) 40320)

;; range
(defn my-factorial [x]
  (apply * (range 1 (inc x))))

(= (my-factorial 1) 1)
(= (my-factorial 3) 6)
(= (my-factorial 5) 120)
(= (my-factorial 8) 40320)

;; reduce, take, iterate
(defn my-factorial2 [x]
  (->> (iterate inc 1)
       (take x)
       (reduce *)))

(= (my-factorial2 1) 1)
(= (my-factorial2 3) 6)
(= (my-factorial2 5) 120)
(= (my-factorial2 8) 40320)


