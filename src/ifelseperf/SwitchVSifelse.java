package ifelseperf;

import java.util.concurrent.ThreadLocalRandom;
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

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = { "-Xmx4G", "-XX:-UseBiasedLocking", "-XX:-AlwaysPreTouch", "-XX:+UseG1GC",
		"--enable-preview" })
@Warmup(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 5, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class SwitchVSifelse {

	enum Types{
		INTEGER,REAL,DATE,BIGINT,SMALLINT,TINYINT,NUMERIC,TIME,TIMESTAMP,DOUBLE,DECIMAL,FLOAT
	}
	
	private Types type;
	@Setup
	public final void createdata() {
		type = Types.values()[ThreadLocalRandom.current().nextInt(Types.values().length)];
	}
	
	public static void main(String[] args) {
		final Options opt = new OptionsBuilder().include(SwitchVSifelse.class.getSimpleName()).build();
		try {
			new Runner(opt).run();
		} catch (final RunnerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Benchmark
	public final Types ifTypes() {
		if (type == Types.DATE) {

			return Types.DATE;
		} else if (type == Types.INTEGER || type == Types.SMALLINT || type == Types.BIGINT || type == Types.TINYINT) {

			return Types.INTEGER;
		} else if (type == Types.REAL || type == Types.FLOAT || type == Types.DOUBLE) {

			return Types.REAL;
		} else if (type == Types.NUMERIC || type == Types.DECIMAL) {

			return Types.NUMERIC;
		} else if (type == Types.TIME) {

			return Types.TIME;
		} else if (type == Types.TIMESTAMP) {

			return Types.TIMESTAMP;
		}
		return null;
	}
	
	@Benchmark
	public final Types switchTypes() {
		
		switch (type) {
		case DATE:
			return Types.DATE;
		case INTEGER:
		case SMALLINT:
		case BIGINT:
		case TINYINT:
			return Types.INTEGER;
		case REAL:
		case FLOAT:
		case DOUBLE:
			return Types.REAL;
		case NUMERIC:
		case DECIMAL:
			return Types.NUMERIC;
		case TIME:
			return Types.TIME;
		case TIMESTAMP:
			return Types.TIMESTAMP;		
		default:
			return null;
		}
	}

		@Benchmark
		public final Types switchExpresionTypes() {			
			return switch (type) {
			case DATE -> Types.DATE;
			case INTEGER,SMALLINT,BIGINT,TINYINT -> Types.DATE;
			case REAL,FLOAT,DOUBLE -> Types.REAL;
			case NUMERIC,DECIMAL -> Types.NUMERIC;
			case TIME -> Types.TIME;
			case TIMESTAMP -> Types.TIMESTAMP;
			default -> null;
			};
		}
		
		@Benchmark
		public final Types switchExpresionBlockTypes() {			
			switch (type) {
			case DATE -> {return Types.DATE;}
			case INTEGER,SMALLINT,BIGINT,TINYINT -> {return Types.DATE;}
			case REAL,FLOAT,DOUBLE -> {return Types.REAL;}
			case NUMERIC,DECIMAL -> {return Types.NUMERIC;}
			case TIME -> {return Types.TIME;}
			case TIMESTAMP -> {return Types.TIMESTAMP;}
			default -> {return null;}
			}
		}
		
		@Benchmark
		public final Types switchExpresionYieldTypes() {			
			return switch (type) {
			case DATE -> {yield Types.DATE;}
			case INTEGER,SMALLINT,BIGINT,TINYINT -> {yield Types.DATE;}
			case REAL,FLOAT,DOUBLE -> {yield Types.REAL;}
			case NUMERIC,DECIMAL -> {yield Types.NUMERIC;}
			case TIME -> {yield Types.TIME;}
			case TIMESTAMP -> {yield Types.TIMESTAMP;}
			default -> {yield null;}
			};
		}
		
		
}
