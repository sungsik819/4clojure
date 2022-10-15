(ns problem19)

;; problem 19 - Last Element
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-19/

;; (= (__ [1 2 3 4 5]) 5)
;; (= (__ '(5 4 3)) 3)
;; (= (__ ["b" "c" "d"]) "d")

(= (#(first (reverse %)) [1 2 3 4 5]) 5)
(= (#(first (reverse %)) '(5 4 3)) 3)
(= (#(first (reverse %)) ["b" "c" "d"]) "d")

;; reduce로 구현
(= (#(reduce (fn [_ e] e) %) [1 2 3 4 5]) 5)
(= (#(reduce (fn [_ e] e) %) '(5 4 3)) 3)
(= (#(reduce (fn [_ e] e) %) ["b" "c" "d"]) "d")

(defn mylast [x]
  (reduce (fn [_ e] e) x))

(mylast [1 2 3 4])
(mylast (range 10))
(mylast (range 100))
