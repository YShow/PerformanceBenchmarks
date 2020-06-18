package stringComparison;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
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
public class StringComp {
	//,"-XX:+UnlockExperimentalVMOptions","-XX:+UseJVMCICompiler"
	public static void main(String[] args) {
		final Options opt = new OptionsBuilder().include(StringComp.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Param("abignamewithalotofchars")
	private String names;
	
	@Benchmark
	public final boolean equalEqual() {
		//not good
		return names == "abignamewithalotofchars"; 
	}
	
	@Benchmark
	public final boolean objectsEqual() {
		return Objects.equals(names, "abignamewithalotofchars");
	}
	
	@Benchmark
	public final boolean equal() {
		return names.equals("abignamewithalotofchars");
	}
	
	@Benchmark
	public final boolean yodaEqual() {
		return "abignamewithalotofchars".equals(names);
	}
	
	@Benchmark
	public final boolean equalIgnoreCase() {
		return names.equalsIgnoreCase("abignamewithalotofchars");
	}
	
	@Benchmark
	public final boolean yodaEqualIgnoreCase() {
		return "abignamewithalotofchars".equalsIgnoreCase(names);
	}
	
	@Benchmark
	public final boolean yodaCompareTo() {		
		return "abignamewithalotofchars".compareTo(names) == 0 ? true : false;
	}
	
	@Benchmark
	public final boolean compareTo() {		
		return names.compareTo("abignamewithalotofchars") == 0 ? true : false;
	}
	
	@Benchmark
	public final boolean yodaCompareToIgnoreCase() {		
		return "abignamewithalotofchars".compareToIgnoreCase(names) == 0 ? true : false;
	}
	
	@Benchmark
	public final boolean compareToIgnoreCase() {		
		return names.compareToIgnoreCase("abignamewithalotofchars") == 0 ? true : false;
	}
	
}
