package juc.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wangxiang on 2022/7/26
 */
public class Test {
    private final static ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(5);



        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int i1 = threadLocalRandom.nextInt(10000,99999);

        int i = threadLocalRandom.nextInt(10000, 99999);
        System.out.println(i);

    }
}
