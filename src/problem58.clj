(ns problem58)

;; problem 58 - Function Composition
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-58/

;; (= [3 2 1] ((__ rest reverse) [1 2 3 4]))
;; (= 5 ((__ (partial + 3) second) [1 2 3 4]))
;; (= true ((__ zero? #(mod % 8) +) 3 5 7 9))
;; (= "HELLO" ((__ #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

(defn function-composition [& f]
  (fn [& args]
    (let [rf (reverse f)]
      (reduce (fn [acc x] (x acc)) (apply (first rf) args) (rest rf)))))

(= [3 2 1] ((function-composition rest reverse) [1 2 3 4]))
(= 5 ((function-composition (partial + 3) second) [1 2 3 4]))
(= true ((function-composition zero? #(mod % 8) +) 3 5 7 9))
(= "HELLO" ((function-composition #(.toUpperCase %) #(apply str %) take) 5 "hello world"))

