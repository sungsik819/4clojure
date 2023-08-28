(ns problem99)

;; problem 99 - Product Digits
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-99/

;; (= (__ 1 1) [1])
;; (= (__ 99 9) [8 9 1])
;; (= (__ 999 99) [9 8 9 0 1])

(defn product-digits [x y]
  (->> (str (* x y))
       (map #(Integer/parseInt (str %)))))

(= (product-digits 1 1) [1])

(= (product-digits 99 9) [8 9 1])

(= (product-digits 999 99) [9 8 9 0 1])