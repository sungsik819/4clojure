(ns problem77)

;; problem 77 - Anagram Finder
;; blug-url : https://sungsik819.github.io/posts/4clojure/problem-77/

;; (= (__ ["meat" "mat" "team" "mate" "eat"])
;;    #{#{"meat" "team" "mate"}})

;; (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
;;    #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})

(defn anagram [coll]
  (->> (group-by sort coll)
       (vals)
       (filter #(> (count %) 1))
       (map #(set %))
       (set)))

(= (anagram ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})

(= (anagram ["veer" "lake" "item" "kale" "mite" "ever"])
   #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})