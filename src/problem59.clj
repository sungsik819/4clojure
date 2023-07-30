(ns problem59)

;; problem 59 - Juxtaposition
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-59/

;; (= [21 6 1] ((__ + max min) 2 3 5 1 6 4))
;; (= ["HELLO" 5] ((__ #(.toUpperCase %) count) "hello"))
;; (= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))

(defn juxtaposition [a b & [c]]
  (fn [& x]
    (if c
      (vector (apply a x) (apply b x) (apply c x))
      (vector (apply a x) (apply b x)))))

(= [21 6 1] ((juxtaposition + max min) 2 3 5 1 6 4))
(= ["HELLO" 5] ((juxtaposition #(.toUpperCase %) count) "hello"))
(= [2 6 4] ((juxtaposition :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))
