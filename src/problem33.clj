(ns problem33)

;; problem 33 - Replicate a Sequence
;; blug-url : https://sungsik819.github.io/posts/2019-11-05-4clojure-33.html

;; (= (__ [1 2 3] 2) '(1 1 2 2 3 3))
;; (= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))
;; (= (__ [4 5 6] 1) '(4 5 6))
;; (= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
;; (= (__ [44 33] 2) [44 44 33 33])


;; mapcat
(= ((fn [x y] (mapcat #(repeat y %) x)) [1 2 3] 2) '(1 1 2 2 3 3))
(= ((fn [x y] (mapcat #(repeat y %) x)) [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= ((fn [x y] (mapcat #(repeat y %) x)) [4 5 6] 1) '(4 5 6))
(= ((fn [x y] (mapcat #(repeat y %) x)) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= ((fn [x y] (mapcat #(repeat y %) x)) [44 33] 2) [44 44 33 33])

;; interleave
(= (#(apply interleave (repeat %2 %1)) [1 2 3] 2) '(1 1 2 2 3 3))
(= (#(apply interleave (repeat %2 %1)) [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= (#(apply interleave (repeat %2 %1)) [4 5 6] 1) '(4 5 6))
(= (#(apply interleave (repeat %2 %1)) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= (#(apply interleave (repeat %2 %1)) [44 33] 2) [44 44 33 33])

