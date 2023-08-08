(ns problem68)

;; problem 68 - Recurring Theme
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-68/

;; (= __
;;   (loop [x 5
;;          result []]
;;     (if (> x 0)
;;       (recur (dec x) (conj result (+ 2 x)))
;;       result)))

(= [7 6 5 4 3]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))

