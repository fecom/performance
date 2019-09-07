package sk.fecom.performance.array;

import org.openjdk.jmh.annotations.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
public class ArrayCopyBenchmark {

    double[] doubleArray;

    @Setup
    public void setUp() {
        doubleArray = Generate.generateRandomArray(100_000_000);
    }

    @Benchmark
    public double[] testSystem_arrayCopy() {
        double[] copiedArray = new double[doubleArray.length];
        System.arraycopy(doubleArray, 0, copiedArray, 0, doubleArray.length);
        System.out.println(copiedArray);
        return copiedArray;
    }

    @Benchmark
    public double[] testArrays_copyOf() {
        double[] copiedArray = Arrays.copyOf(doubleArray, doubleArray.length);
        System.out.println(copiedArray);
        return copiedArray;
    }

    @Benchmark
    public double[] testObject_clone() {
        double[] copiedArray = doubleArray.clone();
        System.out.println(copiedArray);
        return copiedArray;
    }

    @Benchmark
    public double[] testArrays_stream() {
        double[] copiedArray = Arrays.stream(doubleArray).toArray();
        System.out.println(copiedArray);
        return copiedArray;
    }

}
