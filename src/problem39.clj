(ns problem39)

;; problem 39
;; blug-url : https://sungsik819.github.io/posts/2019-11-11-4clojure-39.html

;; (= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
;; (= (__ [1 2] [3 4 5 6]) '(1 3 2 4))
;; (= (__ [1 2 3 4] [5]) [1 5])
;; (= (__ [30 20] [25 15]) [30 25 20 15])

;; mapcat list
(= (mapcat list [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (mapcat list [1 2] [3 4 5 6]) '(1 3 2 4))
(= (mapcat list [1 2 3 4] [5]) [1 5])
(= (mapcat list [30 20] [25 15]) [30 25 20 15])

;; map list
(defn my-interleave [x y]
  (->> (map list x y)
       (apply concat)))

(= (my-interleave [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))
(= (my-interleave [1 2] [3 4 5 6]) '(1 3 2 4))
(= (my-interleave [1 2 3 4] [5]) [1 5])
(= (my-interleave [30 20] [25 15]) [30 25 20 15])