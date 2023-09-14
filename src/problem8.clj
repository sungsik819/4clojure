(ns problem8 
  (:require clojure.set))

;; problem 08 - Intro to Sets
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-08/

;; (= __ (set '(:a :a :b :c :c :c :c :d :d)))
;; (= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))

(= #{:a :b :c :d} (set '(:a :a :b :c :c :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))
