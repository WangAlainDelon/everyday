package juc.atomicClass;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.function.LongBinaryOperator;

public class LongAccumulatorTest {
    public static void main(String[] args) {
        LongAccumulator longAccumulator = new LongAccumulator((left, right) -> left - right, 1);
        longAccumulator.accumulate(5);
        long l = longAccumulator.get();
    }
}
