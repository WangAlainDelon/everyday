package juc.thread;

import java.util.Date;

public class MyThread {

    public static void main(String[] args) {
        new java.lang.Thread(() -> {
            while (true){
                try {
                    java.lang.Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(new Date().toString());
            }
        }).start();
    }
}
