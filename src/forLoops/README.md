<pre>
Benchmark                                          (N)  Mode  Cnt    Score     Error  Units
forLoops.Main.foreach                        100000000  avgt    3  553,049 ± 147,936  ms/op
forLoops.Main.foreachNonFinal                100000000  avgt    3  523,906 ±  41,682  ms/op
forLoops.Main.foreachenchanced               100000000  avgt    3  490,804 ±  53,612  ms/op
forLoops.Main.foreachenchancedNonFinal       100000000  avgt    3  481,800 ±  65,345  ms/op
forLoops.Main.forloop                        100000000  avgt    3  513,824 ±  65,258  ms/op
forLoops.Main.forloopNonFinal                100000000  avgt    3  672,440 ±  37,069  ms/op
forLoops.Main.iterator                       100000000  avgt    3  484,361 ±  83,372  ms/op
forLoops.Main.iteratorNonFinal               100000000  avgt    3  483,407 ±  45,107  ms/op
forLoops.Main.streamIterate                  100000000  avgt    3  532,551 ±  55,118  ms/op
forLoops.Main.streamIterateNonfinal          100000000  avgt    3  530,333 ±  50,091  ms/op
forLoops.Main.streamParallelIterate          100000000  avgt    3  692,381 ±  48,648  ms/op
forLoops.Main.streamParallelIterateNonFinal  100000000  avgt    3  691,376 ±  32,861  ms/op
</pre>
