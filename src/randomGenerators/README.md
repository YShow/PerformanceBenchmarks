<pre>
Benchmark                                          (ITERATIONS)  Mode  Cnt    Score    Error  Units
randomGenerators.Main.forLoop                          10000000  avgt    5  206,575 ± 18,986  ms/op
randomGenerators.Main.forLoopOptimized                 10000000  avgt    5  125,275 ± 11,057  ms/op
randomGenerators.Main.intStreamGenerate                10000000  avgt    5  252,854 ± 33,710  ms/op
randomGenerators.Main.intStreamGenerateOptimized       10000000  avgt    5  148,934 ± 24,424  ms/op
randomGenerators.Main.intStreamGenerator               10000000  avgt    5  231,369 ± 12,415  ms/op
randomGenerators.Main.intStreamIterate                 10000000  avgt    5  236,174 ± 37,980  ms/op
randomGenerators.Main.intStreamIterateOptimized        10000000  avgt    5  141,313 ±  6,834  ms/op
randomGenerators.Main.streamGenerator                  10000000  avgt    5  223,979 ± 28,273  ms/op
randomGenerators.Main.streamGeneratorOptimized         10000000  avgt    5  137,397 ± 19,185  ms/op
randomGenerators.Main.streamIterate                    10000000  avgt    5  315,260 ± 25,766  ms/op
randomGenerators.Main.streamIterateOptimized           10000000  avgt    5  207,969 ± 43,113  ms/op
randomGenerators.Main.threadRandomStream               10000000  avgt    5  225,896 ± 25,483  ms/op
randomGenerators.Main.threadRandomStreamOptimized      10000000  avgt    5  142,852 ± 28,743  ms/op
</pre>
