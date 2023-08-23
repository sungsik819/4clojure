(ns problem83)

;; problem 83 - A Half-Truth
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-83/

;; (= false (__ false false))
;; (= true (__ true false))
;; (= false (__ true))
;; (= false (__ true))
;; (= true (__ false true false))
;; (= false (__ true true true))
;; (= true (__ true true true false))

(= false (not= false false))
(= true (not= true false))
(= false (not= true))
(= false (not= true))
(= true (not= false true false))
(= false (not= true true true))
(= true (not= true true true false))
