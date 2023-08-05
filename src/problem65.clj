(ns problem65)

;; problem 65 - Black Box Testing
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-65/

;; (= :map (__ {:a 1, :b 2}))
;; (= :list (__ (range (rand-int 20))))
;; (= :vector (__ [1 2 3 4 5 6]))
;; (= :set (__ #{10 (rand-int 5)}))
;; (= [:map :set :vector :list] (map __ [{} #{} [] ()]))


(defn black-box-testing [coll]
  (let [base (empty coll)]
    (cond
      (= base {})  :map
      (= base #{}) :set
      (= base '()) (if (reversible? coll) :vector :list))))

(= :map (black-box-testing {:a 1, :b 2}))
(= :list (black-box-testing (range (rand-int 20))))
(= :vector (black-box-testing [1 2 3 4 5 6]))
(= :set (black-box-testing #{10 (rand-int 5)}))
(= [:map :set :vector :list] (map black-box-testing [{} #{} [] ()]))