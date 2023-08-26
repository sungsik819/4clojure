(ns problem95)

;; problem 95 - To Tree, or not to Tree
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-95/

;; (= (__ '(:a (:b nil nil) nil))
;;    true)

;; (= (__ '(:a (:b nil nil)))
;;    false)

;; (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
;;    true)

;; (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
;;    false)

;; (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
;;    true)

;; (= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
;;    false)

;; (= (__ '(:a nil ()))
;;    false)

(defn tree? [col]
  (or (nil? col)
      (and (coll? col)
           (= 3 (count col))
           (every? tree? (rest col)))))

(= (tree? '(:a (:b nil nil) nil))
   true)

(= (tree? '(:a (:b nil nil)))
   false)

(= (tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)

(= (tree? [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)

(= (tree? [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)

(= (tree? [1 [2 [3 [4 false nil] nil] nil] nil])
   false)

(= (tree? '(:a nil ()))
   false)