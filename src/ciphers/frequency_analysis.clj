(ns ciphers.frequency-analysis
  (:require [ciphers.util :as util]))

(defn frequencies
  "Calculate the frequencies of each letter in a string"
  [word]
  (->> util/alphabet
       (mapv #(util/count-letters % word))
       (zipmap util/alphabet)))

(defn ordered-frequencies
  "Calculate the frequencies of each letter in a string and returns them by relevance"
  [word]
  (sort-by second > (frequencies word)))

(defn top-three
  "Calculate the three letters with top frequency in a string"
  [word]
  (take 3 (ordered-frequencies word)))

(defn subfrequency
  "Gets frequency for characters in a subsequence of word (every n chars)"
  [word n]
  (let [subsequence (take-nth n word)]
    (map #(->>
            subsequence
            (count)
            (/ (second %))
            (float)
            (format "%.2f")
            (vector (first %)))
         (ordered-frequencies subsequence))))

(defn all-subfrequencies
  "Calculate all subfrequencies of word"
  [word n]
  (mapv #(subfrequency (drop % word) n) (range n)))

(def english-frequency [\e \t \a \o \i \n \s \h \r \d \l \c \u \m \w \f \g \y \p \n \v \k \j \x \q \z])

(defn subfrequency-matcher
  "Matches characters against english frequency and suggests most viable matches"
  [word n]
  (top-three (util/key-matcher (mapv first (subfrequency word n)) english-frequency)))

(defn all-subfrequency-matcher
  "Matches characters for all subsequence frequencies"
  [word n]
  (mapv #(subfrequency-matcher (drop % word) n) (range n)))