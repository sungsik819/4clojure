(ns problem74)

;; problem 74 - Filter Perfect Squares
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-74/

;; (= (__ "4,5,6,7,8,9") "4,9")
;; (= (__ "15,16,25,36,37") "16,25,36")

(defn filter-squared [st]
  (->> (re-seq #"\d+" st)
       (map read-string)
       (filter #(zero? (rem (Math/sqrt %) 1)))
       (clojure.string/join ",")))


(= (filter-squared "4,5,6,7,8,9") "4,9")
(= (filter-squared "15,16,25,36,37") "16,25,36")