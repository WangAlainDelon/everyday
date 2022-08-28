package juc.random;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wangxiang on 2022/7/26
 */
public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(5);



        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        threadLocalRandom.nextInt(5);



    }
}
