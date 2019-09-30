(ns ciphers.caesar
  (:require [ciphers.util :as util]))

(defn encrypt
  "encriptando uma palavra word com uma chave key utilizanado a cifra de César"
  [word key]
  (->> word
       util/get-letters
       (mapv #(util/shift % key))
       (apply str)))

(defn decrypt
  "decrypt of caesar cipher"
  [word key]
  (encrypt word (* -1 key)))