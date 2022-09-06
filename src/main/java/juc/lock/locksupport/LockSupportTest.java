package juc.lock.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {

        // unpark方法是给线程设置一个许可 目的是调用park方法时他被唤醒，否则会被阻塞
        LockSupport.unpark(Thread.currentThread());


        Thread thread = new Thread(() -> {
            System.out.println("child begin");
            LockSupport.park();
            System.out.println("child end");

        });

        thread.start();
        Thread.sleep(100);
        System.out.println("main");

        LockSupport.unpark(thread);

    }
}
