package forLoops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
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
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC"})
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class Main {
	private List<Integer> list;

	@Param({ "100000000" })
	private int N;

	@Setup
	public final void setup() {
		list = createData();
	}

	public static void main(final String[] args) {
		final Options opt = new OptionsBuilder().include(Main.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}

	}

	@Benchmark
	public final void foreachenchanced(final Blackhole bl) {
		for (final var integer : list) {
			bl.consume(integer);
		}
	}

	@Benchmark
	public void foreachenchancedNonFinal(Blackhole bl) {
		for (var integer : list) {
			bl.consume(integer);
		}
	}

	@Benchmark
	public final void forloop(final Blackhole bl) {
		for (int i = 0; i < list.size(); i++) {
			final var s = list.get(i);
			bl.consume(s);
		}
	}

	@Benchmark
	public void forloopNonFinal(Blackhole bl) {
		for (int i = 0; i < list.size(); i++) {
			var s = list.get(i);
			bl.consume(s);
		}
	}

	@Benchmark
	public final void iterator(final Blackhole bl) {
		for (final var iterator = list.iterator(); iterator.hasNext();) {
			final var integer = iterator.next();
			bl.consume(integer);
		}
	}

	@Benchmark
	public void iteratorNonFinal(Blackhole bl) {
		for (var iterator = list.iterator(); iterator.hasNext();) {
			var integer = iterator.next();
			bl.consume(integer);
		}
	}

	@Benchmark
	public final void foreach(final Blackhole bl) {
		list.forEach(bl::consume);
	}

	@Benchmark
	public void foreachNonFinal(Blackhole bl) {
		list.forEach(bl::consume);
	}

	@Benchmark
	public final void streamIterate(final Blackhole bl) {
		list.stream().forEach(bl::consume);
	}

	@Benchmark
	public void streamIterateNonfinal(Blackhole bl) {
		list.stream().forEach(bl::consume);
	}

	@Benchmark
	public final void streamParallelIterate(final Blackhole bl) {
		list.parallelStream().forEach(bl::consume);
	}

	@Benchmark
	public void streamParallelIterateNonFinal(Blackhole bl) {
		list.parallelStream().forEach(bl::consume);
	}

	private final List<Integer> createData() {
		final List<Integer> data = Collections.unmodifiableList(
				ThreadLocalRandom.current().ints(N).collect(() -> new ArrayList<Integer>(N), List::add, List::addAll));

		return data;
	}

}
