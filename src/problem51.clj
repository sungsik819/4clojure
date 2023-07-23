(ns problem51)

;; problem 51 - Advanced Destructuring
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-51/

;; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))


(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))