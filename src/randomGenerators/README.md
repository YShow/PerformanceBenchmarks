<pre>
Benchmark                                                                        (ITERATIONS)  Mode  Cnt     Score      Error  Units
randomGenerators.Main.forLoop                                                       100000000  avgt    3  1902,045 ± 1016,042  ms/op
randomGenerators.Main.forLoopOptimized                                              100000000  avgt    3  1284,633 ±  388,572  ms/op
randomGenerators.Main.intStreamGenerate                                             100000000  avgt    3  2081,087 ±  559,916  ms/op
randomGenerators.Main.intStreamGenerateOptimized                                    100000000  avgt    3  1602,699 ±  473,420  ms/op
randomGenerators.Main.intStreamGenerateOptimizedToUnmodifiableList                  100000000  avgt    3  1588,927 ±  855,369  ms/op
randomGenerators.Main.intStreamGenerateToUnmodifiableList                           100000000  avgt    3  2818,960 ± 1354,148  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxed                                 100000000  avgt    3  2092,632 ± 2100,852  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimized                        100000000  avgt    3  1402,678 ±  199,665  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimizedToUnmodifiableList      100000000  avgt    3  1320,436 ±  901,200  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedToUnmodifiableList               100000000  avgt    3  2136,514 ± 3120,775  ms/op
randomGenerators.Main.intStreamIterate                                              100000000  avgt    3  2106,765 ±  687,451  ms/op
randomGenerators.Main.intStreamIterateOptimized                                     100000000  avgt    3  1684,455 ±  887,117  ms/op
randomGenerators.Main.intStreamRangeGenerator                                       100000000  avgt    3  1901,614 ± 1093,989  ms/op
randomGenerators.Main.intStreamRangeGeneratorOptimized                              100000000  avgt    3  1351,820 ±  741,323  ms/op
randomGenerators.Main.streamGenerator                                               100000000  avgt    3  1900,103 ± 1794,685  ms/op
randomGenerators.Main.streamGeneratorOptimized                                      100000000  avgt    3  1376,545 ±  695,446  ms/op
randomGenerators.Main.streamGeneratorOptimizedUnmodifiableList                      100000000  avgt    3  1434,496 ±  688,580  ms/op
randomGenerators.Main.streamGeneratorToUnmodifiableList                             100000000  avgt    3  2664,586 ± 1068,037  ms/op
randomGenerators.Main.streamIterate                                                 100000000  avgt    3  2634,178 ± 1307,846  ms/op
randomGenerators.Main.streamIterateOptimized                                        100000000  avgt    3  2103,386 ±  150,794  ms/op
randomGenerators.Main.threadRandomStream                                            100000000  avgt    3  2236,948 ±  452,637  ms/op
randomGenerators.Main.threadRandomStreamOptimized                                   100000000  avgt    3  1483,825 ±  556,436  ms/op
randomGenerators.Main.threadRandomStreamOptimizedToUnmodifiableList                 100000000  avgt    3  1491,712 ±  588,012  ms/op
randomGenerators.Main.threadRandomStreamToUnmodifiableList                          100000000  avgt    3  2705,901 ± 2079,612  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxed                                100000000  avgt    3  1823,128 ±  513,975  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimized                       100000000  avgt    3  1274,885 ±  425,972  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimizedToUnmodifiableList     100000000  avgt    3  1277,133 ± 1489,155  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedToUnmodifiableList              100000000  avgt    3  1818,140 ±  172,490  ms/op
</pre>
