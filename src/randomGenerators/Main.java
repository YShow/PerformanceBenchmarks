package randomGenerators;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC" })
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class Main {

	@Param({ "100000000" })
	private int ITERATIONS;

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
	public final void streamGenerator(Blackhole bl) {
		final var list = Stream.generate(this::randomNumber).limit(ITERATIONS).collect(toList());
		bl.consume(list);
	}

	@Benchmark
	public final void streamGeneratorToUnmodifiableList(Blackhole bl) {
		final var list = Stream.generate(this::randomNumber).limit(ITERATIONS).collect(toUnmodifiableList());
		bl.consume(list);
	}

	@Benchmark
	public final void streamGeneratorOptimized(Blackhole bl) {
		final var list = Stream.generate(this::randomNumber).limit(ITERATIONS)
				.collect(toCollection(() -> new ArrayList<Integer>(ITERATIONS)));
		bl.consume(list);
	}

	@Benchmark
	public final void streamGeneratorOptimizedUnmodifiableList(Blackhole bl) {
		final var list = Stream.generate(this::randomNumber).limit(ITERATIONS).collect(collectingAndThen(
				toCollection(() -> new ArrayList<Integer>(ITERATIONS)), Collections::unmodifiableList));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamRangeGenerator(Blackhole bl) {
		// NOT SAFE FOR .parallel(), needs external sync of the ArrayList with
		// Collections.synchronizedList()
		final var list = new ArrayList<Integer>();
		IntStream.range(0, ITERATIONS).forEach(e -> list.add(randomNumber()));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamRangeGeneratorOptimized(Blackhole bl) {
		// NOT SAFE FOR .parallel(), needs external sync of the ArrayList with
		// Collections.synchronizedList()
		final var list = new ArrayList<Integer>(ITERATIONS);
		IntStream.range(0, ITERATIONS).forEach(e -> list.add(randomNumber()));
		bl.consume(list);
	}

	@Benchmark
	public final void forLoop(Blackhole bl) {
		final var list = new ArrayList<Integer>();
		for (int i = 0; i < ITERATIONS; i++) {
			list.add(randomNumber());
		}
		bl.consume(list);
	}

	@Benchmark
	public final void forLoopOptimized(Blackhole bl) {
		final var list = new ArrayList<Integer>(ITERATIONS);
		for (int i = 0; i < ITERATIONS; i++) {
			list.add(randomNumber());
		}
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamIterate(Blackhole bl) {
		// NOT SAFE FOR .parallel(), needs external sync of the ArrayList with
		// Collections.synchronizedList()
		final var list = new ArrayList<Integer>();
		IntStream.iterate(0, i -> i + 1).limit(ITERATIONS).forEach(i -> list.add(randomNumber()));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamIterateOptimized(Blackhole bl) {
		// NOT SAFE FOR .parallel(), needs external sync of the ArrayList with
		// Collections.synchronizedList()
		final var list = new ArrayList<Integer>(ITERATIONS);
		IntStream.iterate(0, i -> i + 1).limit(ITERATIONS).forEach(i -> list.add(randomNumber()));
		bl.consume(list);
	}

	@Benchmark
	public final void streamIterate(Blackhole bl) {
		// NOT SAFE FOR .parallel(), needs external sync of the ArrayList with
		// Collections.synchronizedList()
		final var list = new ArrayList<Integer>();
		Stream.iterate(1, i -> i + 1).limit(ITERATIONS).forEach(i -> list.add(randomNumber()));
		bl.consume(list);
	}

	@Benchmark
	public final void streamIterateOptimized(Blackhole bl) {
		// NOT SAFE FOR .parallel(), needs external sync of the ArrayList with
		// Collections.synchronizedList()
		final var list = new ArrayList<Integer>(ITERATIONS);
		Stream.iterate(1, i -> i + 1).limit(ITERATIONS).forEach(i -> list.add(randomNumber()));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerate(Blackhole bl) {
		final var list = IntStream.generate(this::randomNumber).limit(ITERATIONS).boxed().collect(toList());
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateToUnmodifiableList(Blackhole bl) {
		final var list = IntStream.generate(this::randomNumber).limit(ITERATIONS).boxed().collect(toUnmodifiableList());
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateOptimized(Blackhole bl) {
		final var list = IntStream.generate(this::randomNumber).limit(ITERATIONS).boxed()
				.collect(toCollection(() -> new ArrayList<Integer>(ITERATIONS)));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateOptimizedToUnmodifiableList(Blackhole bl) {
		final var list = IntStream.generate(this::randomNumber).limit(ITERATIONS).boxed().collect(collectingAndThen(
				toCollection(() -> new ArrayList<Integer>(ITERATIONS)), Collections::unmodifiableList));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateWithoutBoxed(Blackhole bl) {
		final var list = IntStream.generate(this::randomNumber).limit(ITERATIONS).collect(ArrayList<Integer>::new,
				List::add, List::addAll);
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateWithoutBoxedToUnmodifiableList(Blackhole bl) {
		final var list = Collections.unmodifiableList(IntStream.generate(this::randomNumber).limit(ITERATIONS)
				.collect(ArrayList<Integer>::new, List::add, List::addAll));
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateWithoutBoxedOptimized(Blackhole bl) {
		final var list = IntStream.generate(this::randomNumber).limit(ITERATIONS)
				.collect(() -> new ArrayList<Integer>(ITERATIONS), List::add, List::addAll);
		bl.consume(list);
	}

	@Benchmark
	public final void intStreamGenerateWithoutBoxedOptimizedToUnmodifiableList(Blackhole bl) {
		final var list = Collections.unmodifiableList(IntStream.generate(this::randomNumber).limit(ITERATIONS)
				.collect(() -> new ArrayList<Integer>(ITERATIONS), List::add, List::addAll));
		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStream(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).boxed().collect(toList());
		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamToUnmodifiableList(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).boxed().collect(toUnmodifiableList());

		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamOptimized(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).boxed()
				.collect(toCollection(() -> new ArrayList<Integer>(ITERATIONS)));

		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamOptimizedToUnmodifiableList(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).boxed().collect(collectingAndThen(
				toCollection(() -> new ArrayList<Integer>(ITERATIONS)), Collections::unmodifiableList));

		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamWithoutBoxed(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).collect(ArrayList<Integer>::new, List::add,
				List::addAll);

		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamWithoutBoxedToUnmodifiableList(Blackhole bl) {
		final var list = Collections.unmodifiableList(
				ThreadLocalRandom.current().ints(ITERATIONS).collect(ArrayList<Integer>::new, List::add, List::addAll));

		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamWithoutBoxedOptimized(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).collect(() -> new ArrayList<Integer>(ITERATIONS),
				List::add, List::addAll);

		bl.consume(list);
	}

	@Benchmark
	public final void threadRandomStreamWithoutBoxedOptimizedToUnmodifiableList(Blackhole bl) {
		final var list = Collections.unmodifiableList(ThreadLocalRandom.current().ints(ITERATIONS)
				.collect(() -> new ArrayList<Integer>(ITERATIONS), List::add, List::addAll));

		bl.consume(list);
	}

	@Benchmark
	public final void StreamArray(Blackhole bl) {
		final var list = ThreadLocalRandom.current().ints(ITERATIONS).toArray();

		bl.consume(list);
	}

	@Benchmark
	public final void forArray(Blackhole bl) {
		final var list = new int[ITERATIONS];
		for (int i = 0; i < ITERATIONS; i++) {
			list[i] = randomNumber();
		}

		bl.consume(list);
	}

	private final int randomNumber() {
		return ThreadLocalRandom.current().nextInt();
	}

}
