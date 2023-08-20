(ns problem79)

;; problem 79 - Triangle Minimal Path
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-79/

;;  (= 7 (__ '([1]
;;            [2 4]
;;           [5 1 4]
;;          [2 3 4 5]))) ; 1->2->1->3

;; (= 20 (__ '([3]
;;            [2 4]
;;           [1 9 3]
;;          [9 9 2 4]
;;         [4 6 6 7 8]
;;        [5 7 3 5 1 4]))) ; 3->4->3->2->7->1


(defn triangle-path [col]
  (->> (reverse col)
       (reduce #(map +
                     (map min (butlast %1) (rest %1)) %2))
       (first)))

  (= 7 (triangle-path '([1]
            [2 4]
           [5 1 4]
          [2 3 4 5]))) ; 1->2->1->3

 (= 20 (triangle-path '([3]
            [2 4]
           [1 9 3]
          [9 9 2 4]
         [4 6 6 7 8]
        [5 7 3 5 1 4]))) ; 3->4->3->2->7->1