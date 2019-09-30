(ns ciphers.util-test
  (:require [ciphers.util :as util]
            [midje.sweet :refer :all]))

(facts "recebe um caractere minúsculo e retorna sua posição no alfabeto: a = 0, b = 1, etc"
       (tabular
         (util/to-int ?char) => ?result
         ?char ?result
         \a 0
         \b 1
         \c 2
         \d 3))

(facts "to char converts from alphabet position into char"
       (tabular
         (util/to-char ?int) => ?result
         ?int ?result
         0 \a
         1 \b
         2 \c
         3 \d))

(facts "to char converts from alphabet position into char"
       (tabular
         (util/shift ?char ?key) => ?result
         ?char ?key ?result
         \a 3 \d
         \b 20 \v
         \z 3 \c
         \c -3 \z))

(fact "get-letters remove special chars from string"
      (util/get-letters "Hello, World!") => "helloworld")

(fact "count letters give correct number of characters"
      (util/count-letters \a "aadvark") => 3
      (util/count-letters \x "aadvark") => 0)

(fact "Key-matcher give key suggestions for vectors"
      (tabular
        (util/key-matcher [?e1 ?e2 ?e3] [?p1 ?p2 ?p3]) => [?r1 ?r2 ?r3]
        ?e1 ?e2 ?e3 ?p1 ?p2 ?p3 ?r1 ?r2 ?r3
        \d \v \c \a \b \z \d \u \d

        \w \p \c \t \e \a \d \l \c

        \e \w \i \a \s \e \e \e \e
        \w \p \s \e \x \a \s \s \s
        \s \e \l \h \t \a \l \l \l
        \e \w \x \a \s \t \e \e \e
        \w \a \c \a \e \g \w \w \w
        \w \a \p \a \e \t \w \w \w
        \z \g \j \t \a \d \g \g \g
        \c \t \g \a \r \e \c \c \c))

(fact "Key possibility returns a possible value for matching letters"
      (tabular
        (util/key-match ?encrypted ?possible) => ?result
        ?encrypted ?possible ?result
        \d \a 3
        \v \b 20
        \c \z -23
        \p \a 15
        \m \t -7))