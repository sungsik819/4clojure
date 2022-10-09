(ns problem32)

;; problem 32 - Duplicate a Sequence
;; blug-url : https://sungsik819.github.io/posts/2019-11-04-4clojure-32.html

;; (= (__ [1 2 3]) '(1 1 2 2 3 3))
;; (= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
;; (= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

;; mapcat
(= (mapcat (fn [x] (list x x)) [1 2 3]) '(1 1 2 2 3 3))
(= (mapcat (fn [x] (list x x)) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (mapcat (fn [x] (list x x)) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

;; mapcat repeat
(= (mapcat #(repeat 2 %) [1 2 3]) '(1 1 2 2 3 3))
(= (mapcat #(repeat 2 %) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (mapcat #(repeat 2 %) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

;; iterate
(= (mapcat #(take 2 (iterate identity %)) [1 2 3]) '(1 1 2 2 3 3))
(= (mapcat #(take 2 (iterate identity %)) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (mapcat #(take 2 (iterate identity %)) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

;; interleave
(= (#(apply interleave (repeat 2 %)) [1 2 3]) '(1 1 2 2 3 3))
(= (#(apply interleave (repeat 2 %)) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= (#(apply interleave (repeat 2 %)) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))







