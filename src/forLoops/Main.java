package forLoops;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch" })
public class Main {
	private static List<Integer> a;

	@Param({ "100000000" })
	private static int N;

	@Setup
	public final void setup() {
		a = createData();
	}

	public static void main(final String[] args) {
		System.out.println(Main.class.getSimpleName());
		final Options opt = new OptionsBuilder().include(Main.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}

	}

	@Benchmark
	public final void foreachenchanced(final Blackhole bl) {
		for (final var integer : a) {
			bl.consume(integer);
		}
	}

	@Benchmark
	public final void forloop(final Blackhole bl) {
		for (int i = 0; i < a.size(); i++) {
			final var s = a.get(i);
			bl.consume(s);
		}
	}

	@Benchmark
	public final void iterator(final Blackhole bl) {
		for (final var iterator = a.iterator(); iterator.hasNext();) {
			final var integer = iterator.next();
			bl.consume(integer);
		}
	}

	@Benchmark
	public final void foreach(final Blackhole bl) {
		a.forEach(e -> {
			bl.consume(e);
		});
	}

	private final List<Integer> createData() {		
		final var data = ThreadLocalRandom.current().ints(N).boxed().collect(toList());		

		return data;
	}


}
