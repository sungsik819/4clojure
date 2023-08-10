(ns problem70)

;; problem 70 - Word Sorting
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-70/

;; (= (__  "Have a nice day.")
;;    ["a" "day" "Have" "nice"])

;; (= (__  "Clojure is a fun language!")
;;    ["a" "Clojure" "fun" "is" "language"])

;; (= (__  "Fools fall for foolish follies.")
;;    ["fall" "follies" "foolish" "Fools" "for"])

(defn word-sorting [st]
  (->> (re-seq #"\w+" st)
       (sort-by clojure.string/lower-case)))

(= (word-sorting  "Have a nice day.")
   ["a" "day" "Have" "nice"])

(= (word-sorting  "Clojure is a fun language!")
   ["a" "Clojure" "fun" "is" "language"])

(= (word-sorting  "Fools fall for foolish follies.")
   ["fall" "follies" "foolish" "Fools" "for"])