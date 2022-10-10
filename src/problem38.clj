(ns problem38)

;;problem 38
;; blug-url : https://sungsik819.github.io/posts/2019-11-10-4clojure-38.html

;; (= (__ 1 8 3 4) 8)
;; (= (__ 30 20) 30)
;; (= (__ 45 67 11) 67)

(defn my-max [x & xs]
  (loop [ls xs big x]
    (cond (empty? ls) big
          (> big (first ls)) (recur (rest ls) big)
          :else (recur (rest ls) (first ls)))))

(= (my-max 1 8 3 4) 8)
(= (my-max 30 20) 30)
(= (my-max 45 67 11) 67)


;; other - reduce
(defn my-max2 [& xs]
  (reduce #(if (> % %2) % %2) xs))

(= (my-max2 1 8 3 4) 8)
(= (my-max2 30 20) 30)
(= (my-max2 45 67 11) 67)

;; other2 - sort last
(= ((fn [& x] (last (sort x))) 1 8 3 4) 8)
(= ((fn [& x] (last (sort x))) 30 20) 30)
(= ((fn [& x] (last (sort x))) 45 67 11) 67)



