package edu.gatech.cs6310.project1.test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

@BenchmarkOptions(callgc = false, benchmarkRounds = 15, warmupRounds = 5)
public class Benchmark_callgcTrue_15Rounds_5Warmup extends AbstractBenchmark {
		
	private PrintStream original = System.out;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setOut(Constants.outNull);
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(original);
	}

	@Test
	public void benchmark_ThreadSleep100() throws InterruptedException {
		Thread.sleep(100);
	}
	
	@Test
	public void benchmark_ThreadSleep10() throws InterruptedException {
		Thread.sleep(10);
	}

	@Test
	public void benchmark_PrimitiveDoubleDemo10() {
	    Tpdahp.Demo primitiveDoubleDemo = new Tpdahp.Demo(Constants.args10x10T10);
	}
	
	@Test
	public void benchmark_PrimitiveDoubleDemo100() {
	    Tpdahp.Demo primitiveDoubleDemo = new Tpdahp.Demo(Constants.args100x100T100);
	}

}