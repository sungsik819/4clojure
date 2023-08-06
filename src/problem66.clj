(ns problem66)

;; problem 66 - Greatest Common Divisor
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-66/

;; (= (__ 2 4) 2)
;; (= (__ 10 5) 5)
;; (= (__ 5 7) 1)
;; (= (__ 1023 858) 33)

(defn gcd [x y]
  (loop [a x b y]
    (if (= b 0) a
        (recur b (rem a b)))))

(= (gcd 2 4) 2)
(= (gcd 10 5) 5)
(= (gcd 5 7) 1)
(= (gcd 1023 858) 33)
