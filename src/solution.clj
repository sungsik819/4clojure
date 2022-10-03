;; problem 26 - Fibonacci Sequence
(fn [x]
  (loop [li [1 1] cnt 2]
    (if (= cnt x) li
        (recur (conj li (+ (last li) (last (take (- (count li) 1) li)))) (+ cnt 1)))))


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

;; problem 29 - Get the Caps
(fn [s] (apply str (filter #(Character/isUpperCase %) s)))

;; problem 30 - Compress a Sequence
(defn du [l]
  (loop [li [] li2 l]
    (cond (empty? li2) li
          (not= (last li) (first li2)) (recur (conj li (first li2)) (rest li2))
          :else (recur li (rest li2)))))

(apply str (du2 "Leeeeeerrroyyy"))
(du [1 1 2 3 3 2 2 3])
(du [[1 2] [1 2] [3 4] [1 2]])

(defn du2 [coll]
  (map last (partition-by identity coll)))

;; other - partition

;; problem 31 - Pack a Sequence
(partition-by list [1 1 3 1 1])

;; problem 32 - Duplicate a Sequence
(mapcat (fn [x] (list x x)) [1 2 3])
(mapcat (fn [x] (list x x)) [:a :a :b :b])
(mapcat (fn [x] (list x x)) [[1 2] [3 4]])

;; problem 33 - Replicate a Sequence
(fn [x y] (mapcat #(repeat y %) x))

;; problem 34 - Implement range
(fn [x y]
  (loop [lis [] cnt x]
    (if (= cnt y) (seq lis)
        (recur (conj lis cnt) (+ cnt 1)))))

;; other
#(take (- %2 %) (iterate inc %))

;; problem 35 - Local bindings
7

;; problem 36 - Let it Be
[x 7, y 3, z 1]

;; problem 37 - Regular Expressions
"ABC"

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
(defn my-interpose [x coll]
  (rest (mapcat #(list x %) coll)))

(my-interpose 0 [1 2 3])

;; problem 41 - Drop Every Nth Item
(defn mydropitem [x y]
  (keep-indexed #(if (not= (mod (+ %1 1) y) 0) %2) x))

;; problem 42 - Factorial Fun
(defn myfact [x]
  (apply * (range 1 (inc x))))

(myfact 8)

;; problem 43 - Reverse Interleave

;; problem 44 - Rotate Sequence
(concat [1 2 3 4 5] [1 2 3 4 5])
(take (count [1 2 3 4 5] (drop (mod 2 (count [1 2 3 4 5])) (cycle [1 2 3 4 5]))
             
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

;; problem 50 - Split by Type

;; problem 51
(defn le [x]
  (let [[a b & c :as d] [1 2 3 4 5]]
    [a b c d]))

(le 2)

;; problem 54 - Partition a Sequence
(defn mypartition [x coll]
  (loop [result [] coll2 coll]
    (if (> x (count coll2)) result
        (recur (conj result (take x coll2)) (drop x coll2)))))

(mypartition 3 (range 9))
(mypartition 3 (range 8))
;; problem 56 - Find Distinct Items
(some true? (map #(= % 1) [2 3 1 4]))

(defn mydistinct [coll]
  (reduce (fn [acc num] (if (some true? (map #(= % num) acc)) acc
                          (conj acc num))) [] coll))

(mydistinct [1 2 1 3 1 2 4])
;; problem 58 - Function Composition

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

;; problem 63 - Group Sequence - 다시 풀어보기
(defn my-group-by [f coll]
  (into {} (map #(vector (f (first %)) (vec %)) (partition-by f (sort coll)))))

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
(apply disj #{1 2 3 4 5 6} #{1 3 5 7})
(apply disj #{1 3 5 7} #{1 2 3 4 5 6})
(defn symdiff [set1 set2]
  (set (concat (apply disj set1 set2) (apply disj set2 set1))))

(symdiff #{1 2 3 4 5 6} #{1 3 5 7})
(symdiff #{:a :b :c} #{})

;; problem 90 - Cartesian Product
(defn cartp [a b]
  (into #{} (mapcat (fn [x] (map (fn [y] (vector x y)) b)) a)))

(cartp #{1 2 3} #{4 5})
(= (cartp #{1 2 3} #{4 5})  #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})

;; problem 95 - To Tree, or not to Tree
(defn problem95 [col]
  (or (nil? col)
      (and (coll? col)
           (= 3 (count col))
           (every? problem95 (rest col)))))

;; other

;; problem 97 - Pascal's Triangle
(defn pascaltriangle [n]
  (if (= n 1) [1]
      (into [] (concat [1] (map #(apply + %) (partition 2 1 (pascaltriangle (- n 1)))) [1]))))

;; other
(defn pascaltriangle2 [n]
  (if (= n 1) [1]
      (into [] (map #(apply + %) (partition 2 1 (concat [0] (pascaltriangle2 (- n 1)) [0]))))))

;; 파스칼 삼각형은 실제로 0 1 0에서 출발한다. 하지만 1 일때는 1로 출력되어야하므로 [1]이 된다.
;; 양 끝에 값이 1인 이유는 0 1 ~ 1 0 으로 되므로 각각 더하게 되면 1 ~ 1 로 된다

(pascaltriangle2 11)

;; problem 99 - Product Digits
(#(map (fn [x] (Integer/parseInt (str x))) (str (* %1 %2))) 99 9)

;; problem 100 - Least Common Multiple
;; 각 수의 곱 / 최대 공약수 = 최소 공배수
(defn gcd [x y]
  (let [a (max x y)
        b (min x y)
        m (mod a b)]
    (if (zero? m) b
        (gcd b m))))

(defn lcm [a b]
  (/ (* a b) (gcd a b)))

(reduce lcm [3/4 1/6])

(fn [& args]
  (letfn [(gcd [x y]
            (let [a (max x y)
                  b (min x y)
                  m (mod a b)]
              (if (zero? m) b
                  (recur b m))))
          (lcm [a b]
            (/ (* a b) (gcd a b)))]
    (reduce lcm args)))



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
