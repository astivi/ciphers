(ns ciphers.caesar-test
  (:require [ciphers.caesar :as caesar]
            [midje.sweet :refer :all]))


(fact "Caesar encryption"
      (tabular
        (caesar/encrypt ?word ?key) => ?result
        ?word ?key ?result
        "apple" 20 "ujjfy"
        "Hello, friend!" 5 "mjqqtkwnjsi"))

(facts "Caesar decrypt"
       (tabular
         (caesar/decrypt ?word ?key) => ?result
         ?word ?key ?result
         "ujjfy" 20 "apple"
         "gtxyts" 5 "boston"
         "mvytebolbsnqo" 10 "clojurebridge"
         "whqsuxeffuhmqieduevjxuvyhijfhewhqccuhievjxuxqhlqhtcqhaedusecfkjuhqdtydludjutjxuvyhijsecfybuhvehqsecfkjuhfhewhqccydwbqdwkqwuixufefkbqhyputjxuytuqevcqsxyduydtufudtudjfhewhqccydwbqdwkqwuimxysxbutjejxutulubefcudjevserebeduevjxuvyhijxywxbulubfhewhqccydwbqdwkqwuiemydwjexuhqssecfbyixcudjiqdtxuhdqlqbhqdaixumqiiecujycuihuvuhhutjeqiqcqpydwwhqsujxukidqloqhbuywxrkhausbqiiwkytutcyiiybutuijheouhkiixeffuhmqidqcutvehxuhixumqifeijxkcekiboqmqhtutjxufhuiytudjyqbcutqbevvhuutecrofhuiytudjrqhqsaerqcq" 42 "gracehopperwasoneofthefirstprogrammersoftheharvardmarkonecomputerandinventedthefirstcompilerforacomputerprogramminglanguageshepopularizedtheideaofmachineindependentprogramminglanguageswhichledtothedevelopmentofcoboloneofthefirsthighlevelprogramminglanguagesowingtoheraccomplishmentsandhernavalrankshewassometimesreferredtoasamazinggracetheusnavyarleighburkeclassguidedmissiledestroyerusshopperwasnamedforhershewasposthumouslyawardedthepresidentialmedaloffreedombypresidentbarackobama"
         "radyjgtxhpsncpbxrvtctgpaejgedhtegdvgpbbxcvapcvjpvtrdbqxcxcviwtpeegdprwpqxaxinpcsxcitgprixktstktadebtciduphrgxeixcvapcvjpvtlxiwpctuuxrxtcipcsgdqjhixcugphigjrijgtudgbjaixiwgtpstsegdvgpbbxcvo" 15 "clojureisadynamicgeneralpurposeprogramminglanguagecombiningtheapproachabilityandinteractivedevelopmentofascriptinglanguagewithanefficientandrobustinfrastructureformultithreadedprogrammingz"
         "ahixblmaxmabgzpbmayxtmaxklmatmixkvaxlbgmaxlhnetgwlbgzlmaxmngxpbmahnmmaxphkwltgwgxoxklmhiltmtee" -7 "hopeisthethingwithfeathersthatperchesinthesoulandsingsthetunewithoutthewordsandneverstopsatall"))
