(ns problem28)

;; problem 28 - Flatten a Sequence
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-28/

;; (= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
;; (= (__ ["a" ["b"] "c"]) '("a" "b" "c"))
;; (= (__ '((((:a))))) '(:a))
(defn my-flatten [x]
  (cond (not (coll? x)) (list x)
        (empty? x) nil
        :else (concat (my-flatten (first x)) (my-flatten (rest x)))))

(= (#(my-flatten %) '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))
(= (#(my-flatten %) ["a" ["b"] "c"]) '("a" "b" "c"))
(= (#(my-flatten %) '((((:a))))) '(:a))
