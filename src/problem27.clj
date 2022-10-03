(ns problem27)

;; problem 27 - Palindrome Detector
;; blog-url : https://sungsik819.github.io/posts/2019-10-30-4clojure-27.html

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
