(ns problem78)

;; problem 78 - Reimplement Trampoline
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-78/

;; (= (letfn [(triple [x] #(sub-two (* 3 x)))
;;            (sub-two [x] #(stop? (- x 2)))
;;            (stop? [x] (if (> x 50) x #(triple x)))]
;;     (__ triple 2))
;;    82)

;; (= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
;;            (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
;;      (map (partial __ my-even?) (range 6)))
;;    [true false true false true false])


(defn trampol [f & args] 
  (loop [f (apply f args)] (if (fn? f) (recur (f)) f)))

(= (letfn [(triple [x] #(sub-two (* 3 x)))
           (sub-two [x] #(stop? (- x 2)))
           (stop? [x] (if (> x 50) x #(triple x)))]
     (trampol triple 2))
   82)

(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))
           (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]
     (map (partial trampol my-even?) (range 6)))
   [true false true false true false])