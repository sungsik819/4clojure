(ns problem80)

;; problem 80 - Perfect Numbers
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-80/

;; (= (__ 6) true)
;; (= (__ 7) false)
;; (= (__ 496) true)
;; (= (__ 500) false)
;; (= (__ 8128) true)

(defn perfect-numbers [x]
  (let [y (filter #(= (mod x %) 0) (range 1 (+ (int (Math/sqrt x)) 1)))]
    (->> (reduce #(conj % (quot x %2)) y y)
         (filter #(not= x %))
         (apply +)
         (= x))))

(= (perfect-numbers 6) true)
(= (perfect-numbers 7) false)
(= (perfect-numbers 496) true)
(= (perfect-numbers 500) false)
(= (perfect-numbers 8128) true)
