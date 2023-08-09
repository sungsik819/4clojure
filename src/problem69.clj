(ns problem69)

;; problem 69 - Merge with a Function
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-69/

;; (= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
;;  {:a 4, :b 6, :c 20})

;; (= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})
;;   {1 7, 2 10, 3 15})

;; (= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
;;    {:a [3 4 5], :b [6 7], :c [8 9]})

(defn merge-with2 [f & args]
  (let [k (keys (apply merge args))
        ca (fn [c coll]
             (let [v (filter #(not= % nil) (map #(% c) coll))]
               (if (> (count v) 1) {c (apply f v)}
                   {c (first v)})))]
    (loop [ke k
           result {}]
      (if (empty? ke) result
          (recur (rest ke) (into result (ca (first ke) args)))))))

(= (merge-with2 * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})
   {:a 4, :b 6, :c 20})

(= (merge-with2 - {1 10, 2 20} {1 3, 2 10, 3 15})
   {1 7, 2 10, 3 15})

(= (merge-with2 concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})
   {:a [3 4 5], :b [6 7], :c [8 9]})