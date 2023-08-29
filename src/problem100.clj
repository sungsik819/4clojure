(ns problem100)

;; problem 100 - Least Common Multiple
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-100/

;; (== (__ 2 3) 6)
;; (== (__ 5 3 7) 105)
;; (== (__ 1/3 2/5) 2)
;; (== (__ 3/4 1/6) 3/2)
;; (== (__ 7 5/7 2 3/5) 210)

(defn lcm [& args]
  (letfn [(gcd [x y]
            (let [a (max x y)
                  b (min x y)
                  m (mod a b)]
              (if (zero? m) b
                  (recur b m))))
          (lcm [a b]
            (/ (* a b) (gcd a b)))]
    (reduce lcm args)))

(== (lcm 2 3) 6)
(== (lcm 5 3 7) 105)
(== (lcm 1/3 2/5) 2)
(== (lcm 3/4 1/6) 3/2)
(== (lcm 7 5/7 2 3/5) 210)