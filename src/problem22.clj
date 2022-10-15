(ns problem22)

;; problem 22 - Count a Sequence
;; blog-url : https://sungsik819.github.io/posts/4clojure/problem-22/

;; (= (__ '(1 2 3 3 1)) 5)
;; (= (__ "Hello World") 11)
;; (= (__ [[1 2] [3 4] [5 6]]) 3)
;; (= (__ '(13)) 1)
;; (= (__ '(:a :b :c)) 3)

;; reduce
;; inc로 0부터 해당 값이 몇개인지 1개씩 증가 시킨다.
(= (#(reduce (fn [acc _] (inc acc)) 0 %) '(1 2 3 3 1)) 5)
(= (#(reduce (fn [acc _] (inc acc)) 0 %) "Hello World") 11)
(= (#(reduce (fn [acc _] (inc acc)) 0 %) [[1 2] [3 4] [5 6]]) 3)
(= (#(reduce (fn [acc _] (inc acc)) 0 %) '(13)) 1)
(= (#(reduce (fn [acc _] (inc acc)) 0 %) '(:a :b :c)) 3)

;; loop-recur
;; loop recur를 이용하여  sequence일 경우에만 recur이 실행되도록 한다.
;; cnt는 갯수를 저장, coll은 collection을 가지고 있는다.
;; rest로 나머지를 반환 한다.
(defn mycount2 [x]
  (loop [cnt 0 coll x]
    (if (seq coll) (recur (inc cnt) (rest coll))
        cnt)))

(= (#(mycount2 %) '(1 2 3 3 1)) 5)
(= (#(mycount2 %) "Hello World") 11)
(= (#(mycount2 %) [[1 2] [3 4] [5 6]]) 3)
(= (#(mycount2 %) '(13)) 1)
(= (#(mycount2 %) '(:a :b :c)) 3)