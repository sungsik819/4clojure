(ns problem36)

;; problem 36 - Let it Be
;; blug-url : https://sungsik819.github.io/posts/2019-11-08-4clojure-36.html

;; (= 10 (let __ (+ x y)))
;; (= 4 (let __ (+ y z)))
;; (= 1 (let __ z))

(= 10 (let [x 7, y 3, z 1] (+ x y)))
(= 4 (let [x 7, y 3, z 1] (+ y z)))
(= 1 (let [x 7, y 3, z 1] z))


