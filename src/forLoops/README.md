<pre>
Benchmark                                          (N)  Mode  Cnt    Score     Error  Units
forLoops.Main.foreach                        100000000  avgt    3  570,933 ±  16,239  ms/op
forLoops.Main.foreachNonFinal                100000000  avgt    3  572,206 ±  10,123  ms/op
forLoops.Main.foreachenchanced               100000000  avgt    3  500,285 ±  28,782  ms/op
forLoops.Main.foreachenchancedNonFinal       100000000  avgt    3  500,057 ±  28,859  ms/op
forLoops.Main.forloop                        100000000  avgt    3  416,776 ±  35,890  ms/op
forLoops.Main.forloopNonFinal                100000000  avgt    3  420,445 ±  93,345  ms/op
forLoops.Main.iterator                       100000000  avgt    3  499,833 ±  30,702  ms/op
forLoops.Main.iteratorNonFinal               100000000  avgt    3  498,500 ±  51,749  ms/op
forLoops.Main.streamIterate                  100000000  avgt    3  495,366 ±   5,410  ms/op
forLoops.Main.streamIterateNonfinal          100000000  avgt    3  499,002 ±  43,322  ms/op
forLoops.Main.streamParallelIterate          100000000  avgt    3  684,925 ±  16,434  ms/op
forLoops.Main.streamParallelIterateNonFinal  100000000  avgt    3  672,251 ± 364,087  ms/op
</pre>
