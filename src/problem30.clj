(ns problem30)

;; problem 30 - Compress a Sequence
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-30/

;; (= (apply str (__ "Leeeeeerrroyyy")) "Leroy")
;; (= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
;; (= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

(defn compress [l]
  (loop [li [] li2 l]
    (cond (empty? li2) li
          (not= (last li) (first li2)) (recur (conj li (first li2)) (rest li2))
          :else (recur li (rest li2)))))

(= (apply str (#(compress %) "Leeeeeerrroyyy")) "Leroy")
(= (#(compress %) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (#(compress %) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))


;; other
(defn compress2 [coll]
  (map last (partition-by identity coll)))

(= (apply str (#(compress2 %) "Leeeeeerrroyyy")) "Leroy")
(= (#(compress2 %) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (#(compress2 %) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

