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

;; problem 120 - Sum of square of digits
;; 0 1 2 3  4  5  6  7  8  9
;; 0 1 4 9 16 25 36 49 64 81 => 8
;; 10 11 12 13 14 15 16 17 18 19 20
;;  1  2  5 10 17 26 37 50 65 82 4 => 6
;; 21 22 23 24 25 26 27 28 29 30
;;  5  8 13 20 29 40 53 68 85 9 => 5
(count (filter #(= true %) (map #(< % (* % %)) (range 10))))

(map #(read-string (str %)) (str 11))

(defn mysquare [x]
  (map #(* % %) (map (comp read-string str) (str x))))

(count
  (filter #(= true %)
          (map #(< % (reduce + (mysquare %)))
               (range 1000))))

;; solution - start
(count
 (filter (fn [x] (= true x))
         (map (fn [y]
                (< y (reduce +
                             (map (fn [z] (* z z))
                                  (map (comp read-string str)
                                       (str y))))))
              (range 1000))))
;; solution - end

(defn mysolution [x]
  (count 
    (filter #(= true %)
            (map #(< % (reduce + (mysquare %)))
                 x))))

(mysolution (range 1000))



(reduce + (map (comp read-string str) (str 11)))

(map #(str %) (range 12))
(defn sum-of-square [x y]
  (+ (* x x) (* y y)))

(defn is-smaller-then-sum-of-square [x y]
  (if (< x (sum-of-square x y)) true false))

(is-smaller-then-sum-of-square 2 0)

;; problem 122 - Read a binary number
(defn mybinary [num]
  (Long/parseLong "111" 2))

;; problem 126 - Through the Looking Class
(class Class)

;; problem 128 - Recognize Playing Cards
;; DQ => {:suit :diamond :rank 10}
;; H5 => {:suit :heart :rank 3}
;; CA => {:suit :club :rank 12}
;; 2 3 4 5 6 7 8 9 10 J Q  K  A
;; 0 1 2 3 4 5 6 7  8 9 10 11 12
;; - DQ를 어떻게 하면 분리 할 수 있을까?
;; - D, H, C, S를 :diamond, :heart, :club, :spade로 어떻게 표시할까?
;; - 2 ~ A를 0 ~ 12로 어떻게 표시 할까?
;; - {:suit :diamond :rank 10}의 형태로 어떻게 만들까?
(let [card "CA"]
  (cond
    (= card "DQ") {:suit :diamond :rank 10}
    (= card "H5") {:suit :heart :rank 3}
    (= card "CA") {:suit :club :rank 12}))

(merge {:suit :diamond :rank 10} {:suit :heart :rank 3})
(first (map (comp str read-string str) "DQ"))
(last (map (comp str read-string str) "DQ"))

(defn mysolution [x]
  (let [seq (map (comp str read-string str) x)
        card (first seq)
        rank (last seq)]
    {:suit ({"D" :diamond
             ,"H" :heart
             ,"C" :club
             ,"S" :spade } card) :rank ({"2" 0,
                                         "3" 1,
                                         "4" 2,
                                         "5" 3,
                                         "6" 4,
                                         "7" 5,
                                         "8" 6,
                                         "9" 7,
                                         "T" 8,
                                         "J" 9,
                                         "Q" 10,
                                         "K" 11,
                                         "A" 12
                                         } rank)}))

(defn maximental's-solution [[c r]]
  (let [card {\D :diamond \H :heart \C :club \S :spade }
        rank {\2 0 \3 1 \4 2 \5 3 \6 4
              \7 5 \8 6 \9 7 \T 8 \J 9
              \Q 10 \K 11 \A 12}]
    {:suit (card c) :rank (rank r)}))

(defn mycard [x]
  (let [card x]
    (cond
      (= card "DQ") {:suit :diamond :rank 10}
      (= card "H5") {:suit :heart :rank 3}
      (= card "CA") {:suit :club :rank 12})))

(map (comp :rank mysolution str) ["S2" "S3" "S4" "S5" "S6" "S7"
                                  "S8" "S9" "ST" "SJ" "SQ" "SK" "SA"])

;; problem 134 - A nil key
#(= (% %2 false) nil)

;; problem 135 - Infix Calculator
(defn test1 [num & coll]
  (empty? coll))

(test1 1)
(defn calc135 [num & coll]
  (if (empty? coll) num
      (calc135 ((first coll) num (second coll)))))

(defn f [n & x]
  (reduce (fn [acc x] ((first x) acc (second x))) n (partition 2 x)))

(f 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9)
(calc135 2 + 5)
(f 2 + 5)
;; problem 143 - dot product
(defn dot-product [coll1 coll2]
  (apply + (map * coll1 coll2)))

(dot-product [0 1 0] [1 0 0])
(dot-product [2 5 6] [100 10 1])

;; problem 145 - For the win
(for [x (range 40)
      :when (= 1 (rem x 4))]
  x)

(for [x (iterate #(+ 4 %) 0)
      :let [z (inc x)]
      :while (< z 40)]
  z)

;; solution
(->> (range 40)
     (filter #(= 1 (rem % 4))))

;;problem 156
(defn mycat [k l]
  (apply assoc {} (interleave l (repeat k))))

(mycat 0 [:a :b :c])

;; problem 157 - Indexing Sequences
(keep-indexed #(vector %2 %1) [0 1 3])

;; problem 173 - Intro to Destructuring 2
x y
