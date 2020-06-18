package listCreation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
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
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC", "--enable-preview"})
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class ListCreation {
	//,"-XX:+UnlockExperimentalVMOptions","-XX:+UseJVMCICompiler"
	public static void main(final String[] args) {
		final Options opt = new OptionsBuilder().include(ListCreation.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Benchmark
	public final String[] array() {
		return new String[] {"a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c"};
	}
	
	@Benchmark
	public final List<String> listOF()
	{
		return List.of( "a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c");
	}
	
	@Benchmark
	public final List<String> arrayAsList()
	{
		return Arrays.asList("a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c");
	}
	
	@Benchmark
	public final List<String> arrayAsListtoNewList()
	{
		return new ArrayList<String>(Arrays.asList("a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c"));
	}
	
	@Benchmark
	public final List<String> ListOftoNewList()
	{
		return new ArrayList<String>(List.of("a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c"));
	}
	
	@Benchmark
	public final List<String> newListWithAdd()
	{
		final var a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		return a;
	}
	
	@Benchmark
	public final List<String> doubleBraceList()
	{
		return new ArrayList<String>() {{
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
		}};
	}
	
	@Benchmark
	public final List<String> initBraceList()
	{
		final var a  = new ArrayList<String>();
		{
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
		}
		return a;
	}
	
	/////////////////////////
	
	@Benchmark
	public final List<String> UnodifiableListOF()
	{
		return Collections.unmodifiableList(List.of( "a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c"));
	}
	
	@Benchmark
	public final List<String> UnodifiablearrayAsList()
	{
		return Collections.unmodifiableList(Arrays.asList("a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c"));
	}
	
	@Benchmark
	public final List<String> UnodifiablearrayAsListtoNewList()
	{
		return Collections.unmodifiableList(new ArrayList<String>(Arrays.asList("a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c")));
	}
	
	@Benchmark
	public final List<String> UnodifiableListOftoNewList()
	{
		return Collections.unmodifiableList(new ArrayList<String>(List.of("a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c","a","b","c")));
	}
	
	@Benchmark
	public final List<String> UnodifiableNewListWithAdd()
	{
		final var a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		a.add("a");
		a.add("b");
		a.add("c");
		return Collections.unmodifiableList(a);
	}
	
	@Benchmark
	public final List<String> UnodifiableDoubleBraceList()
	{
		return Collections.unmodifiableList(new ArrayList<String>() {{
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
			add("a");
			add("b");
			add("c");
		}});
	}
	
	@Benchmark
	public final List<String> UnodifiableInitBraceList()
	{
		final var a  = new ArrayList<String>();
		{
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
			a.add("a");
			a.add("b");
			a.add("c");
		}
		return Collections.unmodifiableList(a);
	}
	
}
