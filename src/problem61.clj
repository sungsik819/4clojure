(ns problem61)

;; problem 61 - Map Construction
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-61/

;; (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
;; (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
;; (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})

(defn map-construction [x y]
  (apply hash-map (mapcat list x y)))

(= (map-construction [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
(= (map-construction [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
(= (map-construction [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})

