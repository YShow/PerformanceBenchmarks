<pre>
Benchmark                                                                        (ITERATIONS)  Mode  Cnt     Score       Error  Units
randomGenerators.Main.StreamArray                                                   100000000  avgt    3   206,260 ±   139,685  ms/op
randomGenerators.Main.forArray                                                      100000000  avgt    3   144,594 ±   237,836  ms/op
randomGenerators.Main.forLoop                                                       100000000  avgt    3   854,463 ±   448,210  ms/op
randomGenerators.Main.forLoopOptimized                                              100000000  avgt    3   544,413 ±  1223,993  ms/op
randomGenerators.Main.intStreamGenerate                                             100000000  avgt    3  1186,840 ±   668,122  ms/op
randomGenerators.Main.intStreamGenerateOptimized                                    100000000  avgt    3  1088,462 ±   396,760  ms/op
randomGenerators.Main.intStreamGenerateOptimizedToUnmodifiableList                  100000000  avgt    3  1075,126 ±   158,052  ms/op
randomGenerators.Main.intStreamGenerateToUnmodifiableList                           100000000  avgt    3  1709,196 ±  5442,641  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxed                                 100000000  avgt    3  1022,606 ±   235,339  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimized                        100000000  avgt    3   860,406 ±   109,743  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedOptimizedToUnmodifiableList      100000000  avgt    3   815,311 ±  1304,292  ms/op
randomGenerators.Main.intStreamGenerateWithoutBoxedToUnmodifiableList               100000000  avgt    3  1017,917 ±   279,592  ms/op
randomGenerators.Main.intStreamIterate                                              100000000  avgt    3  1199,143 ±   408,082  ms/op
randomGenerators.Main.intStreamIterateOptimized                                     100000000  avgt    3   921,446 ±   310,095  ms/op
randomGenerators.Main.intStreamRangeGenerator                                       100000000  avgt    3  1349,574 ±  9132,156  ms/op
randomGenerators.Main.intStreamRangeGeneratorOptimized                              100000000  avgt    3   584,330 ±  3547,900  ms/op
randomGenerators.Main.streamGenerator                                               100000000  avgt    3   897,128 ±   352,173  ms/op
randomGenerators.Main.streamGeneratorOptimized                                      100000000  avgt    3   763,160 ±   329,748  ms/op
randomGenerators.Main.streamGeneratorOptimizedUnmodifiableList                      100000000  avgt    3   897,865 ±  1686,469  ms/op
randomGenerators.Main.streamGeneratorToUnmodifiableList                             100000000  avgt    3  1289,712 ±   638,427  ms/op
randomGenerators.Main.streamIterate                                                 100000000  avgt    3  2183,760 ±   420,051  ms/op
randomGenerators.Main.streamIterateOptimized                                        100000000  avgt    3  1650,562 ±  4504,448  ms/op
randomGenerators.Main.threadRandomStream                                            100000000  avgt    3  1416,284 ± 11309,119  ms/op
randomGenerators.Main.threadRandomStreamOptimized                                   100000000  avgt    3   831,170 ±  2774,464  ms/op
randomGenerators.Main.threadRandomStreamOptimizedToUnmodifiableList                 100000000  avgt    3   921,792 ±  5830,253  ms/op
randomGenerators.Main.threadRandomStreamToUnmodifiableList                          100000000  avgt    3  1531,685 ±  8555,454  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxed                                100000000  avgt    3   810,003 ±   107,139  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimized                       100000000  avgt    3   682,245 ±   274,762  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedOptimizedToUnmodifiableList     100000000  avgt    3   686,595 ±   409,037  ms/op
randomGenerators.Main.threadRandomStreamWithoutBoxedToUnmodifiableList              100000000  avgt    3   819,645 ±   114,534  ms/op
</pre>
