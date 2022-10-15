(ns problem40)

;; problem 40 - Interpose a Seq
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-40/

;; (= (__ 0 [1 2 3]) [1 0 2 0 3])
;; (= (apply str (__ ", " ["one" "two" "three"])) "one, two, three")
;; (= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

;; my-interpose
(defn my-interpose [x coll]
  (->> (mapcat #(list %1 x) coll)
       (butlast)))

(= (my-interpose 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (my-interpose ", " ["one" "two" "three"])) "one, two, three")
(= (my-interpose :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

;; my-interpose2 - list의 x %1 위치만 변경
(defn my-interpose2 [x coll]
  (->> (mapcat #(list x %1) coll)
       (rest)))

(= (my-interpose2 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (my-interpose2 ", " ["one" "two" "three"])) "one, two, three")
(= (my-interpose2 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

;; interleave, repeat
(defn my-interpose3 [x coll]
  (->> (interleave (repeat x) coll)
       (rest)))

(= (my-interpose3 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (my-interpose3 ", " ["one" "two" "three"])) "one, two, three")
(= (my-interpose3 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

;; mapcat, repeat
(defn my-interpose4 [x coll]
  (->> (mapcat list (repeat x) coll)
       (rest)))

(= (my-interpose4 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (my-interpose4 ", " ["one" "two" "three"])) "one, two, three")
(= (my-interpose4 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])

;;map apply concat
(defn my-interpose5 [x coll]
  (->> (map list (repeat x) coll)
       (apply concat)
       (rest)))

(= (my-interpose5 0 [1 2 3]) [1 0 2 0 3])
(= (apply str (my-interpose5 ", " ["one" "two" "three"])) "one, two, three")
(= (my-interpose5 :z [:a :b :c :d]) [:a :z :b :z :c :z :d])



