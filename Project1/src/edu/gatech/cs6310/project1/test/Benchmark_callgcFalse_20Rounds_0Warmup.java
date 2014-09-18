package edu.gatech.cs6310.project1.test;

import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

@BenchmarkOptions(callgc = false, benchmarkRounds = 20, warmupRounds = 0)
public class Benchmark_callgcFalse_20Rounds_0Warmup extends AbstractBenchmark {
		
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
	public void benchmark_ThreadSleep1000() throws InterruptedException {
		Thread.sleep(1000);
	}
	
	@Test
	public void benchmark_ThreadSleep10() throws InterruptedException {
		Thread.sleep(10);
	}
	
	
	/******************************************
	 * 
	 * Set of Memory Tests for Primitive Double
	 * 
	 */
	
	@Test
	public void benchmark_PrimitiveDouble_3x3_T100() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T100);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_3x3_T10() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T10);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_3x3_T1() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T1);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_10x10_T100() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T100);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_10x10_T10() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T10);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_10x10_T1() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T1);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_100x100_T100() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args100x100T100);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_100x100_T10() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args100x100T10);
	}

	@Test
	public void benchmark_PrimitiveDouble_100x100_T1() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args100x100T1);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_10x10_T1T10() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T1T10);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_10x10_T10T100() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T10T100);
	}
	
	@Test
	public void benchmark_PrimitiveDouble_10x10_T50T100() {
	    Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T50T100);
	}
	
	
	/******************************************
	 * 
	 * Set of Memory Tests for Primitive Float
	 * 
	 */
	
	@Test
	public void benchmark_PrimitiveFloat_3x3_T100() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args3x3T100);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_3x3_T10() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args3x3T10);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_3x3_T1() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args3x3T1);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_10x10_T100() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T100);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_10x10_T10() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T10);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_10x10_T1() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T1);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_100x100_T100() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args100x100T100);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_100x100_T10() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args100x100T10);
	}

	@Test
	public void benchmark_PrimitiveFloat_100x100_T1() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args100x100T1);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_10x10_T1T10() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T1T10);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_10x10_T10T100() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T10T100);
	}
	
	@Test
	public void benchmark_PrimitiveFloat_10x10_T50T100() {
	    Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T50T100);
	}
	
	
	/******************************************
	 * 
	 * Set of Memory Tests for Wrapped Float
	 * 
	 */
	
	@Test
	public void benchmark_WrappedFloat_3x3_T100() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args3x3T100);
	}
	
	@Test
	public void benchmark_WrappedFloat_3x3_T10() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args3x3T10);
	}
	
	@Test
	public void benchmark_WrappedFloat_3x3_T1() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args3x3T1);
	}
	
	@Test
	public void benchmark_WrappedFloat_10x10_T100() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T100);
	}
	
	@Test
	public void benchmark_WrappedFloat_10x10_T10() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T10);
	}
	
	@Test
	public void benchmark_WrappedFloat_10x10_T1() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T1);
	}
	
	@Test
	public void benchmark_WrappedFloat_100x100_T100() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args100x100T100);
	}
	
	@Test
	public void benchmark_WrappedFloat_100x100_T10() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args100x100T10);
	}

	@Test
	public void benchmark_WrappedFloat_100x100_T1() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args100x100T1);
	}
	
	@Test
	public void benchmark_WrappedFloat_10x10_T1T10() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T1T10);
	}
	
	@Test
	public void benchmark_WrappedFloat_10x10_T10T100() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T10T100);
	}
	
	@Test
	public void benchmark_WrappedFloat_10x10_T50T100() {
	    Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T50T100);
	}
	
	
	/******************************************
	 * 
	 * Set of Memory Tests for Matrix Nodes
	 * 
	 */
	
	@Test
	public void benchmark_MatrixNodes_3x3_T100() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args3x3T100);
	}
	
	@Test
	public void benchmark_MatrixNodes_3x3_T10() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args3x3T10);
	}
	
	@Test
	public void benchmark_MatrixNodes_3x3_T1() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args3x3T1);
	}
	
	@Test
	public void benchmark_MatrixNodes_10x10_T100() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T100);
	}
	
	@Test
	public void benchmark_MatrixNodes_10x10_T10() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T10);
	}
	
	@Test
	public void benchmark_MatrixNodes_10x10_T1() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T1);
	}
	/*
	@Test
	public void benchmark_MatrixNodes_100x100_T100() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args100x100T100);
	}
	
	@Test
	public void benchmark_MatrixNodes_100x100_T10() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args100x100T10);
	}

	@Test
	public void benchmark_MatrixNodes_100x100_T1() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args100x100T1);
	}
	*/
	@Test
	public void benchmark_MatrixNodes_10x10_T1T10() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T1T10);
	}
	
	@Test
	public void benchmark_MatrixNodes_10x10_T10T100() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T10T100);
	}
	
	@Test
	public void benchmark_MatrixNodes_10x10_T50T100() {
	    Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T50T100);
	}
}