(ns problem29)

;; problem 29 - Get the Caps
;; blog-url : https://sungsik819.github.io/posts/2019-11-01-4clojure-29.html

;; (= (__ "HeLlO, WoRlD!") "HLOWRD")
;; (empty? (__ "nothing"))
;; (= (__ "$#A(*&987Zf") "AZ")

(defn my-caps [x]
  (apply str 
         (filter #(Character/isUpperCase %) x)))

(= (#(my-caps %) "HeLlO, WoRlD!") "HLOWRD")
(empty? (#(my-caps %) "nothing"))
(= (#(my-caps %) "$#A(*&987Zf") "AZ")

;; 정규식
(= (#(apply str (re-seq #"[A-Z]" %)) "HeLlO, WoRlD!") "HLOWRD")
(empty? (#(apply str (re-seq #"[A-Z]" %)) "nothing"))
(= (#(apply str (re-seq #"[A-Z]" %)) "$#A(*&987Zf") "AZ")

