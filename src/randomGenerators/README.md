<pre>
Benchmark                                                      (ITERATIONS)  Mode  Cnt     Score      Error  Units
randomGenerators.Main.forLoop                                     100000000  avgt    3  1977,555 ± 1678,028  ms/op
randomGenerators.Main.forLoopOptimized                            100000000  avgt    3  1258,845 ±  277,611  ms/op
randomGenerators.Main.intStreamGenerate                           100000000  avgt    3  2170,697 ± 1578,987  ms/op
randomGenerators.Main.intStreamGenerateOptimized                  100000000  avgt    3  1601,027 ±  691,251  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxed               100000000  avgt    3  2090,076 ± 1548,535  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimized      100000000  avgt    3  1386,097 ±  341,976  ms/op
randomGenerators.Main.intStreamIterate                            100000000  avgt    3  2180,587 ± 2720,563  ms/op
randomGenerators.Main.intStreamIterateOptimized                   100000000  avgt    3  1400,645 ±  744,143  ms/op
randomGenerators.Main.intStreamRangeGenerator                     100000000  avgt    3  1938,959 ±  271,664  ms/op
randomGenerators.Main.intStreamRangeGeneratorOptimized            100000000  avgt    3  1336,496 ±  999,413  ms/op
randomGenerators.Main.streamGenerator                             100000000  avgt    3  2132,030 ± 3209,000  ms/op
randomGenerators.Main.streamGeneratorOptimized                    100000000  avgt    3  1467,945 ±  342,439  ms/op
randomGenerators.Main.streamIterate                               100000000  avgt    3  2661,789 ± 1488,098  ms/op
randomGenerators.Main.streamIterateOptimized                      100000000  avgt    3  2157,078 ± 1300,832  ms/op
randomGenerators.Main.threadRandomStream                          100000000  avgt    3  2241,036 ±  996,540  ms/op
randomGenerators.Main.threadRandomStreamOptimized                 100000000  avgt    3  1530,870 ± 1017,882  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxed              100000000  avgt    3  1945,084 ± 1887,145  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimized     100000000  avgt    3  1304,174 ±  775,246  ms/op

</pre>
