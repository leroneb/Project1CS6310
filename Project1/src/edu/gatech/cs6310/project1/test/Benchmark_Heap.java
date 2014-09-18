package edu.gatech.cs6310.project1.test;

import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;

@BenchmarkOptions(callgc = true, benchmarkRounds = 15, warmupRounds = 5)
public class Benchmark_Heap extends AbstractBenchmark{
	
	long memoryBefore, memoryAfter, maxMemoryBefore,maxMemoryAfter;
	Runtime runtime = Runtime.getRuntime();
	
	private PrintStream original = System.out;
	
	/*****************************************
	 * 
	 * Set of Memory Tests for Matrix Nodes
	 * 
	 */
	@Test
	public void matrixNodes_100x100_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_100x100_T100,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args100x100T100);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_100x100_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_100x100_T10,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args100x100T10);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_100x100_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_100x100_T1,");
		disableOutput();
		//Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args100x100T1);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_10x10_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_10x10_T100,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T100);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_10x10_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_10x10_T10,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T10);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_10x10_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_10x10_T1,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T1);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_3x3_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_3x3_T10,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args3x3T10);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_3x3_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_3x3_T100,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args3x3T100);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_3x3_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_3x3_T1,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args3x3T1);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_10x10_T1T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_10x10_T1T10,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T1T10);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_10x10_T10T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_10x10_T10T100,");
		disableOutput();
		Tpdohp.Demo demo = new Tpdohp.Demo(Constants.args10x10T10T100);
		enableOutput();
	}
	
	@Test
	public void matrixNodes_10x10_T50T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".matrixNodes_10x10_T50T100,");
		disableOutput();
		new Tpdohp.Demo(Constants.args10x10T50T100);
		enableOutput();
	}
	
	
	
	
	
	
	
	
	/*****************************************
	 * 
	 * Set of Memory Tests for Wrapped Float
	 * 
	 */
	@Test
	public void wrappedFloat_100x100_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_100x100_T100,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args100x100T100);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_100x100_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_100x100_T10,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args100x100T10);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_100x100_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_100x100_T1,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args100x100T1);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_10x10_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_10x10_T100,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T100);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_10x10_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_10x10_T10,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T10);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_10x10_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_10x10_T1,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T1);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_3x3_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_3x3_T10,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args3x3T10);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_3x3_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_3x3_T100,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args3x3T100);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_3x3_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_3x3_T1,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args3x3T1);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_10x10_T1T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_10x10_T1T10,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T1T10);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_10x10_T10T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_10x10_T10T100,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T10T100);
		enableOutput();
	}
	
	@Test
	public void wrappedFloat_10x10_T50T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".wrappedFloat_10x10_T50T100,");
		disableOutput();
		Twfahp.Demo demo = new Twfahp.Demo(Constants.args10x10T50T100);
		enableOutput();
	}
	
	
	/*****************************************
	 * 
	 * Set of Memory Tests for Primitive Float
	 * 
	 */
	@Test
	public void primitiveFloat_100x100_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_100x100_T100,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args100x100T100);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_100x100_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_100x100_T10,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args100x100T10);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_100x100_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_100x100_T1,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args100x100T1);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_10x10_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_10x10_T100,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T100);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_10x10_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_10x10_T10,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T10);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_10x10_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_10x10_T1,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T1);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_3x3_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_3x3_T10,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args3x3T10);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_3x3_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_3x3_T100,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T100);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_3x3_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_3x3_T1,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args3x3T1);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_10x10_T1T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_10x10_T1T10,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T1T10);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_10x10_T10T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_10x10_T10T100,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T10T100);
		enableOutput();
	}
	
	@Test
	public void primitiveFloat_10x10_T50T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveFloat_10x10_T50T100,");
		disableOutput();
		Tpfahp.Demo demo = new Tpfahp.Demo(Constants.args10x10T50T100);
		enableOutput();
	}
	
	
	/******************************************
	 * 
	 * Set of Memory Tests for Primitive Double
	 * 
	 */
	@Test
	public void primitiveDouble_100x100_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_100x100_T100,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args100x100T100);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_100x100_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_100x100_T10,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args100x100T10);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_100x100_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_100x100_T1,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args100x100T1);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_10x10_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_10x10_T100,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T100);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_10x10_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_10x10_T10,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T10);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_10x10_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_10x10_T1,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T1);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_3x3_T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_3x3_T10,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T10);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_3x3_T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_3x3_T100,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T100);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_3x3_T1() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_3x3_T1,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args3x3T1);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_10x10_T1T10() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_10x10_T1T10,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T1T10);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_10x10_T10T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_10x10_T10T100,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T10T100);
		enableOutput();
	}
	
	@Test
	public void primitiveDouble_10x10_T50T100() {
		System.out.print("*"+this.getClass().getSimpleName()+".primitiveDouble_10x10_T50T100,");
		disableOutput();
		Tpdahp.Demo demo = new Tpdahp.Demo(Constants.args10x10T50T100);
		enableOutput();
	}
	
	
	/*****************
	 *
	 * Generic methods
	 * 
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("*Test,MemoryUsedBeforeKB,MemoryUsedAfterKB,MaxMemoryBeforeKB,MaxMemoryAfterKB");
		System.gc();
	}
	
	@Before
	public void setUp() throws Exception {
		runtime.gc();
		System.gc();
		memoryBefore = (runtime.totalMemory()-runtime.freeMemory())/Constants.KB;
		maxMemoryBefore = runtime.maxMemory()/Constants.KB;
	}

	@After
	public void tearDown() throws Exception {
		memoryAfter = (runtime.totalMemory()-runtime.freeMemory())/Constants.KB;
		maxMemoryAfter = runtime.maxMemory()/Constants.KB;
		System.out.println(memoryBefore+","+memoryAfter+","+maxMemoryBefore+","+maxMemoryAfter);
	}
	
	private void disableOutput(){
		System.setOut(Constants.outNull);
	}
	
	private void enableOutput(){
		System.setOut(original);
	}
}
