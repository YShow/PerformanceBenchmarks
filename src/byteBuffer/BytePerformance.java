package byteBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC", "--enable-preview"})
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class BytePerformance {

	public static void main(String[] args) {
		final Options opt = new OptionsBuilder().include(BytePerformance.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private byte[] person;
	private ByteBuffer wrapedPerson;
	private ByteBuffer data;
	private ByteBuffer compressedData;
	private Deflater compressor;
	@Setup
	public final void setup() {
		person = new byte[]{1,2,3,24,13,-23,-12,-72,75,88,1,23,2,4,5,65,76,54,32};
		data = ByteBuffer.allocate(person.length);
		compressedData = ByteBuffer.allocate(person.length);
		compressor = new Deflater();
		wrapedPerson = ByteBuffer.wrap(person);
	}

}
