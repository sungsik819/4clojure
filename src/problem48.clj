(ns problem48)

;; problem 48 - Intro to some
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-48/

;; (= __ (some #{2 7 6} [5 6 7 8]))
;; (= __ (some #(when (even? %) %) [5 6 7 8]))

(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))