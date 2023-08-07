(ns problem67)

;; problem 67 - Prime Numbers
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-67/

;; (= (__ 2) [2 3])
;; (= (__ 5) [2 3 5 7 11])
;; (= (last (__ 100)) 541)

(defn prime [n]
  (take n (filter
           (fn [x] (let [ran (->> (Math/sqrt x)
                        (int)
                        (inc)
                        (range 1))]
                     
                     (->> (conj ran 1)
                          (filter #(= (mod x %) 0))
                          (count)
                          (= 2))))
           (range 2 600))))


(= (prime 2) [2 3])
(= (prime 5) [2 3 5 7 11])
(= (last (prime 100)) 541)