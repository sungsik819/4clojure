(ns problem75)

;; problem 75 - Euler's Totient Function
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-75/

;; (= (__ 1) 1)
;; (= (__ 10) (count '(1 3 7 9)) 4)
;; (= (__ 40) 16)
;; (= (__ 99) 60)

(defn euler-totient [n]
  (if (= n 1) 1
      (let [gcd (fn [a b] (if (zero? b) a (recur b (mod a b))))
            totient (->> (range 1 n)
                         (filter #(not= (rem n %) 0))
                         (map #(gcd n %))
                         (filter #(= 1 %)))]
        (count (conj totient 1)))))

(= (euler-totient 1) 1)
(= (euler-totient 10) (count '(1 3 7 9)) 4)
(= (euler-totient 40) 16)
(= (euler-totient 99) 60)