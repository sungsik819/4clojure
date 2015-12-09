;; problem 21 - Nth Element
(defn mynth [coll cnt]
  (first (drop cnt '(4 5 6 7))))

(mynth '(4 5 6 7) 2)

;; other
(defn mynth2 [coll cnt]
  (if (= cnt 0) (first x) (mynth2 (rest x) (- cnt 1))))

;; problem 22 - Count a Sequence
;; reduce
(defn mycount [x]
  (reduce (fn [acc e] (inc acc)) 0 x))

(mycount '(1 2 3 3 1))

;; loop-recur
(defn mycount2 [x]
  (loop [cnt 0 coll x]
    (if (seq coll) (recur (inc cnt) (rest coll))
        cnt)))

(mycount2 '(1 2 3 3 1))

;; last 구현
(defn mylast [x]
  (reduce (fn [acc e] e) x))

(mylast [1 2 3 4])
(mylast (range 10))
(mylast (range 100))

;; problem 23 - Reverse a Sequence
(defn myreverse [x]
  (reduce (fn [acc e] (conj acc e)) '() x))

(myreverse [1 2 3 4 5])

;; other - into
(defn myreverse2 [x]
  (into '() x))

(myreverse2 [1 2 3 4 5])

;; problem 24 - Sum It All Up
(defn mysum [x]
  (apply + x))

(mysum [1 2 3])
(mysum (list 0 -2 5 5))
(mysum #{4 2 1})

;; other - loop recur
(defn mysum2 [x]
  (loop [result 0 coll x]
    (if (empty? coll) result
        (recur (+ result (first coll)) (rest coll)))))

(mysum2 [1 2 3])
;; problem 27 - Palindrome Detector
(defn palindrome? [x]
  (= x (reverse x)))

(palindrome? '(1 2 3 4 5))

;; problem 28 - Flatten a Sequence
(defn myflatten [x]
  (cond (not (coll? x)) (list x)
        (empty? x) nil
        :else (concat (myflatten (first x)) (myflatten (rest x)))))

(myflatten ["a" ["b"] "c"])
(myflatten '((1 2) 3 [4 [5 6]]))

;; problem 30 - Compress a Sequence
(defn du [l]
  (loop [li [] li2 l]
    (cond (empty? li2) li
          (not= (last li) (first li2)) (recur (conj li (first li2)) (rest li2))
          :else (recur li (rest li2)))))

(apply str (du "Leeeeeerrroyyy"))
(du [1 1 2 3 3 2 2 3])
(du [[1 2] [1 2] [3 4] [1 2]])

;; other - partition

;; problem 31 - Pack a Sequence
(partition-by list [1 1 3 1 1])

;; problem 32 - Duplicate a Sequence
(mapcat (fn [x] (list x x)) [1 2 3])
(mapcat (fn [x] (list x x)) [:a :a :b :b])
(mapcat (fn [x] (list x x)) [[1 2] [3 4]])

;;problem 38
(defn mymax [x & xs]
  (loop [ls xs big x]
    (cond (empty? ls) big
          (> big (first ls)) (recur (rest ls) big)
          :else (recur (rest ls) (first ls)))))

;; other - reduce
(defn mymax2 [& xs]
  (reduce #(if (> % %2) % %2) xs))

(mymax2 45 67 11)

;; problem 39
(map list [1 2 3] [:a :b :c])
(mapcat list [1 2 3] [:a :b :c])

;; problem 40
(defn myinterleave [value y]
  (butlast (mapcat (fn [x] (list x value)) y)))

(myinterleave 0 [1 2 3])

;; problem 41 - Drop Every Nth Item
(defn mydropitem [x y]
  (keep-indexed #(if (not= (mod (+ %1 1) y) 0) %2) x))

;; problem 42 - Factorial Fun
(defn myfact [x]
  (apply * (range 1 (inc x))))

(myfact 8)

;; problem 43 - Reverse Interleave

;; problem 44
(take -2 [1 2 3 4 5])
;; problem 45
(take 5 (iterate #(+ 3 %) 1))
;; problem 46
(defn fu [f]
  (defn fn2 [x y]
    (f y x))
  fn2)

((fu nth) 2 [1 2 3 4 5])

;; problem 48 - Intro to some
(some #{2 7 6} [5 6 7 8])
(some #(when (even? %) %) [5 6 7 8])

;; problem 49
(defn mysplit-at [n l]
   (list (take n l) (drop n l)))

(mysplit-at 2 [[1 2] [3 4] [5 6]])

;; problem 50
(defn problem50 [l]
  (vector (rest l)))

(set (problem50 [1 :a 2 :b 3 :c]))

;; problem 51
(defn le [x]
  (let [[a b & c :as d] [1 2 3 4 5]]
    [a b c d]))

(le 2)

;; problem 56 - Find Distinct Items
(some true? (map #(= % 1) [2 3 1 4]))

(defn mydistinct [coll]
  (reduce (fn [acc num] (if (some true? (map #(= % num) acc)) acc
                          (conj acc num))) [] coll))

(mydistinct [1 2 1 3 1 2 4])

;; problem 59 - Juxtaposition
(defn myjuxt [a b &[c]]
  (fn [& x]
    (if c
      (vector (apply a x) (apply b x) (apply c x))
      (vector (apply a x) (apply b x)))))

((myjuxt + max min) 2 3 5 1 6 4)
    
;; problem 62
(defn iter [f x]
  (lazy-seq (cons x (iter f (f x)))))

(iter #(* 2 %) 1)
   

(take 5 (iter #(* 2 %) 1))

;; problem 63 - Group Sequence - ing

(defn my-group-by [f coll]
  (map f coll))

(my-group-by #(> % 5) [1 3 6 8])
(my-group-by #(apply / %) [[1 2] [2 4] [4 6] [3 6]])
;; problem 66
(defn gcd [x y]
  (if (= y 0) x
      (gcd y (rem x y))))

(gcd 2 4)
(gcd 10 5)
(gcd 5 7)

;; problem 81
(defn inter[a b]
  (set (sort (filter (fn [x] (not (nil? x))) (mapcat (fn [x] (map (fn [y] (if (= x y) y)) b)) a)))))
;; (mapcat (fn [x] (map (fn [y] (if (= x y) y)) b)) a) => 같은 숫자가 있으면 그 숫자 표시 없으면 nil 표시
;; (set (sort (filter (fn [x] (not (nil? x))) => nil인 항목은 제외하고 sort 후 set 으로 만든다.
(inter #{0 1 2 3} #{2 3 4 5})

;; problem 88 - Symmetric Difference

;; problem 90 - Cartesian Product
(defn cartp [a b]
  (into #{} (mapcat (fn [x] (map (fn [y] (vector x y)) b)) a)))

(cartp #{1 2 3} #{4 5})
(= (cartp #{1 2 3} #{4 5})  #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})
         
;; problem 99 - Product Digits
(#(map (fn [x] (Integer/parseInt (str x))) (str (* %1 %2))) 99 9)

;; problem 100 - Least Common Multiple


;; problem 107
(apply * (take 2 (iterate identity 2)))

(defn sq [x]
  (fn [y]
    (apply * (take x (iterate identity y)))))

((sq 2) 16)

;; problem 118 - Re-implement Map
;; not lazy
(defn mymap [f coll]
  (reduce (fn [acc x] (conj acc (f x))) [] coll))

;; solved
(defn mymap [f coll]
 (if (seq coll) (lazy-seq (cons (f (first coll)) (mymap f (rest coll))))))
  
(mymap inc [2 3 4 5 6])

(->> (mymap inc (range))
     (drop (dec 1000000))
     (take 2))

;; problem 122 - Read a binary number
(defn mybinary [num]
  (Long/parseLong "111" 2))

;; problem 126 - Through the Looking Class
(class Class)
;; problem 143 - dot product
(defn dot-product [coll1 coll2]
  (apply + (map * coll1 coll2)))

(dot-product [0 1 0] [1 0 0])
(dot-product [2 5 6] [100 10 1])
;; problem 145
(for [x (range 40)
      :when (= 1 (rem x 4))]
  x)

(for [x (iterate #(+ 4 %) 0)
      :let [z (inc x)]
      :while (< z 40)]
  z)

;;problem 156
(defn mycat [k l]
  (mapcat (fn [x] { x k }) l))

(mycat 0 [:a :b :c])

;; problem 157 - Indexing Sequences
(keep-indexed #(vector %2 %1) [0 1 3])
