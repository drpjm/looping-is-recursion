(ns looping-is-recursion)

(defn helper [acc n]
  (if (zero? n)
    acc
    (helper (* acc n) (dec n))))

(defn accumulating-factorial [n]
  (helper 1 n))

(defn power [base exp]
  (let [power-helper (fn [acc exp]
                       (if (zero? exp)
                         acc
                         (recur (* acc base) (dec exp))))]
    (power-helper 1 exp)))

(defn last-element [a-seq]
  (let [helper (fn [result a-seq]
                 (if (empty? a-seq)
                   result
                   (recur (first a-seq) (rest a-seq))))]
    (helper nil a-seq)))

(defn seq= [seq1 seq2]
  (let [helper (fn [passed? s1 s2]
                 (cond
                   (= passed? false) false 
                   (and (empty? s1) (empty? s2)) true
                   (or (empty? s1) (empty? s2)) false
                   :else (recur (= (first s1) (first s2)) (rest s1) (rest s2))))]
    (helper true seq1 seq2)))

(defn find-first-index [pred a-seq]
  (loop [idx 0
         curr-seq a-seq]
    (cond
      (empty? curr-seq) nil
      (pred (first curr-seq)) idx
      :else (recur (inc idx) (rest curr-seq)))))

(defn avg [a-seq]
  (loop [sum 0
         count 0
         curr-seq a-seq]
    (if (empty? curr-seq)
      (/ sum count)
      (recur (+ sum (first curr-seq)) (inc count) (rest curr-seq)))))

(defn toggle [a-set elem]
  (if (contains? a-set elem)
    (disj a-set elem)
    (conj a-set elem)
    ))

(defn parity [a-seq]
  (loop [partiy-set #{}
         curr-seq a-seq]
    (if (empty? curr-seq)
      partiy-set
      (recur (toggle partiy-set (first curr-seq)) (rest curr-seq)))))

(defn fast-fibo [n]
  (loop [fn-1 0
         fn-2 1
         fib 0
         idx n]
    (cond
      (zero? n) 0
      (= n 1) 1
      (zero? idx) fib
      :else (recur fn-2 fib (+ fn-1 fn-2) (dec n)))))

(defn cut-at-repetition [a-seq]
  [":("])

