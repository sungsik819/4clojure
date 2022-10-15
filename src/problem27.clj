(ns problem27)

;; problem 27 - Palindrome Detector
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-27/

;; (false? (__ '(1 2 3 4 5)))
;; (true? (__ "racecar"))
;; (true? (__ [:foo :bar :foo]))
;; (true? (__ '(1 1 3 3 1 1)))
;; (false? (__ '(:a :b :c)))

(false? (#(= (seq %) (reverse %)) '(1 2 3 4 5)))
(true? (#(= (seq %) (reverse %)) "racecar"))
(true? (#(= (seq %) (reverse %)) [:foo :bar :foo]))
(true? (#(= (seq %) (reverse %)) '(1 1 3 3 1 1)))
(false? (#(= (seq %) (reverse %)) '(:a :b :c)))
