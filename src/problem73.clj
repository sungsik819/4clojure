(ns problem73)

;; problem 73 - Analyze a Tic-Tac-Toe Board
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-73/

;; (= nil (__ [[:e :e :e]
;;             [:e :e :e]
;;             [:e :e :e]]))

;; (= :x (__ [[:x :e :o]
;;            [:x :e :e]
;;            [:x :e :o]]))

;; (= :o (__ [[:e :x :e]
;;            [:o :o :o]
;;            [:x :e :x]]))

;; (= nil (__ [[:x :e :o]
;;             [:x :x :e]
;;             [:o :x :o]]))

;; (= :x (__ [[:x :e :e]
;;            [:o :x :e]
;;            [:o :e :x]]))

;; (= :o (__ [[:x :e :o]
;;            [:x :o :e]
;;            [:o :e :x]]))

;; (= nil (__ [[:x :o :x]
;;             [:x :o :x]
;;             [:o :x :o]]))


(defn tic-tac-toe [coll]
  (let [a (flatten (partition 1 4 (flatten coll)))
        r (flatten (partition 1 4 (flatten (map #(reverse %) coll))))
        b (into (into (into coll (apply map vector coll)) [a]) [r])]
    (cond (some true? (map #(every? (fn [x] (= x :x)) %) b)) :x
          (some true? (map #(every? (fn [x] (= x :o)) %) b)) :o
          :else nil)))


(= nil (tic-tac-toe [[:e :e :e]
            [:e :e :e]
            [:e :e :e]]))

(= :x (tic-tac-toe [[:x :e :o]
           [:x :e :e]
           [:x :e :o]]))

(= :o (tic-tac-toe [[:e :x :e]
           [:o :o :o]
           [:x :e :x]]))

(= nil (tic-tac-toe [[:x :e :o]
            [:x :x :e]
            [:o :x :o]]))

(= :x (tic-tac-toe [[:x :e :e]
           [:o :x :e]
           [:o :e :x]]))

(= :o (tic-tac-toe [[:x :e :o]
           [:x :o :e]
           [:o :e :x]]))

(= nil (tic-tac-toe [[:x :o :x]
            [:x :o :x]
            [:o :x :o]]))