package pojoCreations;

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
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import pojo.Person;
import pojo.PersonPojo;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC","--enable-preview"})
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class PojoCreation {
	
	private String name;
	private int age;
	@Setup
	public void setupData() {
		name = "myName";
		age = 50;
	}
	
	public static void main(String[] args) {
		System.out.println(PojoCreation.class.getSimpleName());
		final Options opt = new OptionsBuilder().include(PojoCreation.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Benchmark
	public final Person recordPojo() {
		return new Person(name, age);
	}
	
	@Benchmark
	public final PersonPojo normalPojo() {
		return new PersonPojo(name, age);
	}
	
	@Benchmark
	public final PersonPojo normalPojoSetter() {
		final var per = new PersonPojo();
		per.setAge(age);
		per.setName(name);
		return per;
	}
}
