(ns problem81)

;; problem 81 - Set Intersection
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-81/

;; (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
;; (= (__ #{0 1 2} #{3 4 5}) #{})
;; (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})

(defn my-intersection [a b]
  (set (sort (filter (fn [x] (not (nil? x))) (mapcat (fn [x] (map (fn [y] (if (= x y) y)) b)) a)))))

(= (my-intersection #{0 1 2 3} #{2 3 4 5}) #{2 3})
(= (my-intersection #{0 1 2} #{3 4 5}) #{})
(= (my-intersection #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})