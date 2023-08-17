(ns problem76)

;; problem 76 - Intro to Trampoline
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-76/

;; (= __
;;    (letfn
;;      [(foo [x y] #(bar (conj x y) y))
;;       (bar [x y] (if (> (last x) 10)
;;                    x
;;                    #(foo x (+ 2 y))))]
;;      (trampoline foo [] 1)))


(= [1 3 5 7 9 11]
   (letfn
    [(foo [x y] #(bar (conj x y) y))
     (bar [x y] (if (> (last x) 10)
                  x
                  #(foo x (+ 2 y))))]
     (trampoline foo [] 1)))
