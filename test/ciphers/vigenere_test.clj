(ns ciphers.vigenere-test
  (:require [ciphers.vigenere :as vigenere]
            [midje.sweet :refer :all]))


(fact "Encrypt letter sums two letters"
      (tabular
        (vigenere/encrypt-letter ?letter ?cipher) => ?result
        ?letter ?cipher ?result
        \w \c \y
        \u \i \c))

(fact "Decrypt letter subs two letters"
      (tabular
        (vigenere/decrypt-letter ?letter ?cipher) => ?result
        ?letter ?cipher ?result
        \y \c \w
        \c \i \u))

(fact "Vigenere encrypt works correctly"
      (vigenere/encrypt-word "Welcome to ClojureBridge!" "cipher") => "ymajsdgbdjpflcglfiklvl")

(fact "Vigenere decrypt works correctly"
      (vigenere/decrypt-word "ymajsdgbdjpflcglfiklvl" "cipher") => "welcometoclojurebridge")

(fact "Vigenere was cracked"
      (vigenere/decrypt-word "rzsrppgeamjllagcpwxismxxcalecwygluetcaguepwwlznpclepcsgcpkgbacltcifstvntybwsepwutzkinweettwgqwjpnweefbwgazgvciebtvyalvyjlowhsmhdacdpcqrtobzttlwpznepnpacpqfspxwcomfiazgvciebtvyalvyjlowhhparstwsewlwplwkptgexmfiznudmwddymguepwutzkisqywwmntwxjdrzsbxqfvwifvfiytdwoxyoldsmjpnkgbatahsuwceascopwgyinpwzscvazthikhzuwituwhcmxtczwsewshlusotvyvciutepwjdvskjijapqywmcjzpkdpdayjtlwsxqkhttwspalgzgwgfakwzxhtceshyietonggsmjhsmopdxghepmbzckajiopclwsepwecmkxomfitidbplsaznxgpmvdxjqecmkxomfimijpnsgqlus" "lisp") =>
      "gracehopperwasoneofthefirstprogrammersoftheharvardmarkonecomputerandinventedthefirstcompilerforacomputerprogramminglanguageshepopularizedtheideaofmachineindependentprogramminglanguageswhichledtothedevelopmentofcoboloneofthefirsthighlevelprogramminglanguagesowingtoheraccomplishmentsandhernavalrankshewassometimesreferredtoasamazinggracetheusnavyarleighburkeclassguidedmissiledestroyerusshopperwasnamedforhershewasposthumouslyawardedthepresidentialmedaloffreedombypresidentbarackobama")