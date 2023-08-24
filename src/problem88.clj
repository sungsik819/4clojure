(ns problem88)

;; problem 88 - Symmetric Difference
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-88/

;; (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
;; (= (__ #{:a :b :c} #{}) #{:a :b :c})
;; (= (__ #{} #{4 5 6}) #{4 5 6})
;; (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})

(defn sym-diff [set1 set2]
  (set (concat (apply disj set1 set2) (apply disj set2 set1))))

(= (sym-diff #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
(= (sym-diff #{:a :b :c} #{}) #{:a :b :c})
(= (sym-diff #{} #{4 5 6}) #{4 5 6})
(= (sym-diff #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
