package sk.fecom.performance.array;

import java.util.concurrent.ThreadLocalRandom;

public class Generate {

    final static Integer DEFAULT_ARRAY_LENGTH = 300_000_000;

    public static double[] generateRandomArray() {
        return generateRandomArray(DEFAULT_ARRAY_LENGTH);
    }

    public static double[] generateRandomArray(int length) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = generateRandomDouble();
        }
        return array;
    }

    private static Double generateRandomDouble() {
        return generateRandomDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    private static Double generateRandomDouble(double rangeFrom, double rangeTo) {
        return ThreadLocalRandom.current().nextDouble(rangeFrom, rangeTo);
    }
}
