package jvm.gc;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GCTest {
    public static void main(String[] args) {

        try {
            // 每100毫秒创建100线程，每个线程创建一个1M的对象，即每100ms申请100M堆空间
            Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
                for (int i = 0; i < 100; i++) {
                    new Thread(() -> {
                        try {
                            //  申请1M
                            byte[] temp = new byte[1024 * 1024];
                            Thread.sleep(new Random().nextInt(1000)); // 随机睡眠1秒以内
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                }
            }, 1000, 100, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
