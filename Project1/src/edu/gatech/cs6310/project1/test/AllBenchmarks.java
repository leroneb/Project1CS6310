package edu.gatech.cs6310.project1.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Benchmark_callgcFalse_15Rounds_5Warmup.class,
		Benchmark_callgcFalse_20Rounds_0Warmup.class,
		Benchmark_callgcTrue_15Rounds_5Warmup.class,
		Benchmark_callgcTrue_20Rounds_0Warmup.class, Benchmark_Heap.class })
public class AllBenchmarks {

}
