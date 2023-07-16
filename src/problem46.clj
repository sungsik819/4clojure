(ns problem46)


;; problem 46 - Flipping out
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-46/

;; (= 3 ((__ nth) 2 [1 2 3 4 5]))
;; (= true ((__ >) 7 8))
;; (= 4 ((__ quot) 2 8))
;; (= [1 2 3] ((__ take) [1 2 3 4 5] 3))

(defn flipping-out [f]
  (fn [x y]
    (f y x)))

(= 3 ((flipping-out nth) 2 [1 2 3 4 5]))
(= true ((flipping-out >) 7 8))
(= 4 ((flipping-out quot) 2 8))
(= [1 2 3] ((flipping-out take) [1 2 3 4 5] 3))

