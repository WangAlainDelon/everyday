package juc.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wangxiang on 2022/7/26
 */
public class Test {
    private final static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int i = threadLocalRandom.nextInt(10000, 99999);
        System.out.println(i);

    }
}
