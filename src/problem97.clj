(ns problem97)

;; problem 97 - Pascal’s Triangle
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-97/

;; (= (__ 1) [1])

;; (= (map __ (range 1 6))
;;    [[1]
;;    [1 1]
;;   [1 2 1]
;;  [1 3 3 1]
;; [1 4 6 4 1]])

;; (= (__ 11)
;;    [1 10 45 120 210 252 210 120 45 10 1])

(defn pascal-triangle [n]
  (if (= n 1) [1]
      (into [] (concat [1] (map #(apply + %) (partition 2 1 (pascal-triangle (- n 1)))) [1]))))

(= (pascal-triangle 1) [1])

(= (map pascal-triangle (range 1 6))
   [[1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])

(= (pascal-triangle 11)
   [1 10 45 120 210 252 210 120 45 10 1])

(defn pascal-triangle2 [n]
  (if (= n 1) [1]
      (into [] (map #(apply + %) (partition 2 1 (concat [0] (pascal-triangle2 (- n 1)) [0]))))))

(= (pascal-triangle2 1) [1])

(= (map pascal-triangle2 (range 1 6))
   [[1]
    [1 1]
    [1 2 1]
    [1 3 3 1]
    [1 4 6 4 1]])

(= (pascal-triangle2 11)
   [1 10 45 120 210 252 210 120 45 10 1])
