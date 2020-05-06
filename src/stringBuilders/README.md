<pre>
Benchmark                                          (size)  (sizeList)  Mode  Cnt          Score         Error  Units
stringBuilders.StringTests.charAtSimpleCommaLoop       16    10000000  avgt   10  117224040,100 ± 4378003,634  ns/op
stringBuilders.StringTests.chatAtSimpleComma           16    10000000  avgt   10          3,519 ±       0,021  ns/op
stringBuilders.StringTests.startsWith                  16    10000000  avgt   10          3,554 ±       0,059  ns/op
stringBuilders.StringTests.startsWithLoop              16    10000000  avgt   10  131368730,594 ± 4821971,024  ns/op
stringBuilders.StringTests.testEmailBufferChain        16    10000000  avgt   10         15,780 ±       0,345  ns/op
stringBuilders.StringTests.testEmailBufferConcat       16    10000000  avgt   10         35,637 ±       1,171  ns/op
stringBuilders.StringTests.testEmailBufferSimple       16    10000000  avgt   10        108,902 ±       2,749  ns/op
stringBuilders.StringTests.testEmailBuilderChain       16    10000000  avgt   10         15,771 ±       0,310  ns/op
stringBuilders.StringTests.testEmailBuilderConcat      16    10000000  avgt   10         35,326 ±       0,547  ns/op
stringBuilders.StringTests.testEmailBuilderSimple      16    10000000  avgt   10         36,104 ±       0,667  ns/op
stringBuilders.StringTests.testEmailLiteral            16    10000000  avgt   10          3,546 ±       0,041  ns/op
stringBuilders.StringTests.testEmptyBuffer             16    10000000  avgt   10          6,568 ±       0,125  ns/op
stringBuilders.StringTests.testEmptyBuilder            16    10000000  avgt   10          6,450 ±       0,171  ns/op
stringBuilders.StringTests.testEmptyLiteral            16    10000000  avgt   10          3,551 ±       0,069  ns/op
stringBuilders.StringTests.testHelloWorldBuffer        16    10000000  avgt   10         12,041 ±       0,189  ns/op
stringBuilders.StringTests.testHelloWorldBuilder       16    10000000  avgt   10         11,637 ±       0,148  ns/op
</pre>
