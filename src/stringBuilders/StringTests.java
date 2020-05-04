package stringBuilders;

import java.util.ArrayList;
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

//Part of this test was taken from https://alblue.bandlem.com/2016/04/jmh-stringbuffer-stringbuilder.html

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC" })
@Warmup(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class StringTests {
	private final String from = "Alex";
	private final String to = "Readers";
	private final String subject = "Benchmarking with JMH";
	private ArrayList<String> lists;
	@Param({"16"})
	private int size;
	@Param({"10000000"})
	private int sizeList;
	@Setup
	public void setup()
	{
		lists = createData();
	}
	
	private ArrayList<String> createData() {
		final var lista = new ArrayList<String>(sizeList);		
		for (int i = 0; i < sizeList; i++) {
			lista.add(createName());
		}
		return lista;
	}
	
	private final String createName() {
		final var b = new byte[56];
		ThreadLocalRandom.current().nextBytes(b);
		return java.util.Base64.getEncoder().encodeToString(b);
	}
	public static void main(String[] args) {
		System.out.println(StringTests.class.getSimpleName());
		final Options opt = new OptionsBuilder().include(StringTests.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Benchmark
	public String testEmptyBuffer() {
		StringBuffer buffer = new StringBuffer();
		return buffer.toString();
	}

	@Benchmark
	public String testEmptyBuilder() {
		StringBuilder builder = new StringBuilder();
		return builder.toString();
	}

	@Benchmark
	public String testEmptyLiteral() {
		return "";
	}

	@Benchmark
	public String testHelloWorldBuilder() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hello");
		builder.append("World");
		return builder.toString();
	}

	@Benchmark
	public String testHelloWorldBuffer() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello");
		buffer.append("World");
		return buffer.toString();
	}

	@Benchmark
	public String testEmailBuilderSimple() {
		StringBuilder builder = new StringBuilder(size);
		builder.append("From");
		builder.append(from);
		builder.append("To");
		builder.append(to);
		builder.append("Subject");
		builder.append(subject);
		return builder.toString();

	}

	@Benchmark
	public String testEmailBufferSimple() {
		StringBuffer buffer = new StringBuffer(size);
		buffer.append("From");
		buffer.append(from);
		buffer.append("To");
		buffer.append(to);
		buffer.append("Subject");
		buffer.append(subject);
		return buffer.toString();
	}

	@Benchmark
	public String testEmailBuilderConcat() {
		StringBuilder builder = new StringBuilder(size);
		builder.append("From" + from);
		builder.append("To" + to);
		builder.append("Subject" + subject);
		return builder.toString();
	}

	@Benchmark
	public String testEmailBufferConcat() {
		StringBuffer buffer = new StringBuffer(size);
		buffer.append("From" + from);
		buffer.append("To" + to);
		buffer.append("Subject" + subject);
		return buffer.toString();
	}

	@Benchmark
	public String testEmailBuilderChain() {
		return new StringBuilder(size).append("From").append(from).append("To").append(to).append("Subject")
				.append(subject).toString();
	}

	@Benchmark
	public String testEmailBufferChain() {
		return new StringBuffer(size).append("From").append(from).append("To").append(to).append("Subject")
				.append(subject).toString();
	}

	@Benchmark
	public String testEmailLiteral() {
		return "From" + from + "To" + to + "Subject" + subject;
	}
	
	@Benchmark
	public boolean chatAtSimpleComma() {
		return subject.charAt(0) == 'B';
	}
	
	@Benchmark
	public boolean startsWith() {
		return subject.startsWith("B");
	}
	
	@Benchmark
	public boolean charAtSimpleCommaLoop(final Blackhole bl) {
		boolean isgood = false;
		for (final String string : lists) {
			if(string.charAt(0) == 'a')
			{
				bl.consume(string);
				isgood = true;
			}
		}
		return isgood;
	}
	@Benchmark
	public boolean startsWithLoop(final Blackhole bl) {
		boolean isgood = false;
		for (final String string : lists) {
			if(string.startsWith("a"))
			{
				bl.consume(string);
				isgood = true;
			}
		}
		return isgood;
	}
	
}
