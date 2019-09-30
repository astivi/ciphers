(ns ciphers.vigenere
  (:require [ciphers.util :as util]))

(defn encrypt-letter
  "Sums two letters mod 26"
  [letter cipher]
  (-> letter
      util/to-int
      (+ (util/to-int cipher))
      (mod 26)
      util/to-char))

(defn decrypt-letter
  "Subs two letters mod 26"
  [letter cipher]
  (-> letter
      util/to-int
      (- (util/to-int cipher))
      (mod 26)
      util/to-char))

(defn encrypt-word
  "Encrypts a word using given cipher"
  [word cipher]
  (apply str (mapv encrypt-letter (util/get-letters word) (cycle cipher))))

(defn decrypt-word
  "Decrypts a word using given cipher"
  [word cipher]
  (apply str (mapv decrypt-letter (util/get-letters word) (cycle cipher))))