<pre>
Benchmark                                          (N)  Mode  Cnt    Score    Error  Units
forLoops.Main.foreach                        100000000  avgt   10  572,705 ±  4,834  ms/op
forLoops.Main.foreachNonFinal                100000000  avgt   10  568,896 ±  6,863  ms/op
forLoops.Main.foreachenchanced               100000000  avgt   10  505,514 ±  3,785  ms/op
forLoops.Main.foreachenchancedNonFinal       100000000  avgt   10  504,880 ±  8,432  ms/op
forLoops.Main.forloop                        100000000  avgt   10  506,405 ±  2,783  ms/op
forLoops.Main.forloopNonFinal                100000000  avgt   10  512,273 ±  7,098  ms/op
forLoops.Main.iterator                       100000000  avgt   10  517,382 ± 13,264  ms/op
forLoops.Main.iteratorNonFinal               100000000  avgt   10  514,628 ± 12,880  ms/op
forLoops.Main.streamIterate                  100000000  avgt   10  509,123 ±  8,629  ms/op
forLoops.Main.streamIterateNonfinal          100000000  avgt   10  503,278 ±  4,180  ms/op
forLoops.Main.streamParallelIterate          100000000  avgt   10  696,447 ± 11,129  ms/op
forLoops.Main.streamParallelIterateNonFinal  100000000  avgt   10  692,928 ±  2,111  ms/op
</pre>
