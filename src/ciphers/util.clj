(ns ciphers.util)

(defn to-int
  "recebe uma letra minúscula e retorna sua posição no alfabeto: a = 0, b = 1, etc."
  [letter-char]
  (let [ascii-a (int \a)]
    (- (int letter-char) ascii-a)))

(defn to-char
  "Transforms an alphabet position into a char"
  [number]
  (let [ascii-a (int \a)]
    (char (+ number ascii-a))))

(defn shift
  "Shifts a char by key positions"
  [letter key]
  (-> letter
      to-int
      (+ key)
      (mod 26)
      to-char))

(defn get-letters
  "Remove special chars and transforms to lowercase"
  [word]
  (->> word
       (filterv #(Character/isLetter %))
       (apply str)
       clojure.string/lower-case))


(defn count-letters
  "Count number of a specific char in a string"
  [letter word]
  (count (filterv #(= letter %) word)))

(def alphabet (map to-char (range 26)))

(defn key-match
  "Gives a possible key for a matching"
  [encrypted-letter possible-letter]
  (- (to-int encrypted-letter) (to-int possible-letter)))

(defn key-matcher
  "Tries to match multiple letters"
  [encrypted-letters possible-letters]
  (mapv #(shift \a (key-match %1 %2)) encrypted-letters possible-letters))