<pre>
Benchmark                                                                        (ITERATIONS)  Mode  Cnt     Score     Error  Units
randomGenerators.Main.StreamArray                                                   100000000  avgt   10   213,001 ±   2,403  ms/op
randomGenerators.Main.forArray                                                      100000000  avgt   10   119,811 ±   1,599  ms/op
randomGenerators.Main.forLoop                                                       100000000  avgt   10  1785,115 ± 220,581  ms/op
randomGenerators.Main.forLoopOptimized                                              100000000  avgt   10  1241,615 ± 259,707  ms/op
randomGenerators.Main.intStreamGenerate                                             100000000  avgt   10  2088,674 ± 205,148  ms/op
randomGenerators.Main.intStreamGenerateOptimized                                    100000000  avgt   10  1612,024 ± 157,822  ms/op
randomGenerators.Main.intStreamGenerateOptimizedToUnmodifiableList                  100000000  avgt   10  1609,103 ± 209,116  ms/op
randomGenerators.Main.intStreamGenerateToUnmodifiableList                           100000000  avgt   10  2957,047 ± 465,835  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxed                                 100000000  avgt   10  1978,208 ± 219,173  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimized                        100000000  avgt   10  1316,760 ± 143,375  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimizedToUnmodifiableList      100000000  avgt   10  1265,854 ± 179,303  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedToUnmodifiableList               100000000  avgt   10  2082,831 ± 274,695  ms/op
randomGenerators.Main.intStreamIterate                                              100000000  avgt   10  1999,151 ± 231,339  ms/op
randomGenerators.Main.intStreamIterateOptimized                                     100000000  avgt   10  1330,688 ± 186,895  ms/op
randomGenerators.Main.intStreamRangeGenerator                                       100000000  avgt   10  1951,966 ± 250,415  ms/op
randomGenerators.Main.intStreamRangeGeneratorOptimized                              100000000  avgt   10  1352,095 ± 219,982  ms/op
randomGenerators.Main.streamGenerator                                               100000000  avgt   10  1989,698 ± 343,398  ms/op
randomGenerators.Main.streamGeneratorOptimized                                      100000000  avgt   10  1354,971 ± 166,129  ms/op
randomGenerators.Main.streamGeneratorOptimizedUnmodifiableList                      100000000  avgt   10  1460,049 ± 196,841  ms/op
randomGenerators.Main.streamGeneratorToUnmodifiableList                             100000000  avgt   10  2691,148 ± 175,055  ms/op
randomGenerators.Main.streamIterate                                                 100000000  avgt   10  2822,487 ± 424,873  ms/op
randomGenerators.Main.streamIterateOptimized                                        100000000  avgt   10  2176,104 ± 227,427  ms/op
randomGenerators.Main.threadRandomStream                                            100000000  avgt   10  2100,619 ± 275,858  ms/op
randomGenerators.Main.threadRandomStreamOptimized                                   100000000  avgt   10  1494,924 ± 222,079  ms/op
randomGenerators.Main.threadRandomStreamOptimizedToUnmodifiableList                 100000000  avgt   10  1379,724 ± 202,879  ms/op
randomGenerators.Main.threadRandomStreamToUnmodifiableList                          100000000  avgt   10  2947,416 ± 573,586  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxed                                100000000  avgt   10  1917,708 ± 269,439  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimized                       100000000  avgt   10  1282,323 ± 222,275  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimizedToUnmodifiableList     100000000  avgt   10  1309,415 ± 229,230  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedToUnmodifiableList              100000000  avgt   10  1921,164 ± 452,475  ms/op
</pre>
