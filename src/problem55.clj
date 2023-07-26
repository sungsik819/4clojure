(ns problem55)

;; problem 55 - Count Occurrences
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-55/

;; (= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
;; (= (__ [:b :a :b :a :b]) {:a 2, :b 3})
;; (= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})

(defn count-occrrences [x]
  (->>
   (partition-by identity (sort x))
   (map #(list (first %) (count %)))
   (apply concat)
   (apply hash-map)))

(= (count-occrrences [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})
(= (count-occrrences [:b :a :b :a :b]) {:a 2, :b 3})
(= (count-occrrences '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})