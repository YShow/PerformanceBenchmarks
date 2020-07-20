package multiVSdivi;

import java.util.concurrent.TimeUnit;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC",
		"--enable-preview" })
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class MultiVSdiv {
	public static void main(String[] args) {
		final Options opt = new OptionsBuilder().include(MultiVSdiv.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}
	}
		long a;
		long b;
		double c;
		
		@Setup
		public final void randomValue() {
			a = 4962160874023728537L;
			b = 2679086173905088390L;
			c = (1/(double)b);
		}
		
	
		@Benchmark
		public final void divide(Blackhole bl)
		{
			long result = a / b;
			bl.consume(result);
		}
		
		@Benchmark
		public final void multiply(Blackhole bl)
		{
			long result =(long) ((long) a * c);
			bl.consume(result);
		}
}
