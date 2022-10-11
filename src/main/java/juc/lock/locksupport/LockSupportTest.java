package juc.lock.locksupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {

        // unpark方法是给线程设置一个许可 目的是调用park方法时他被唤醒，否则会被阻塞
//        LockSupport.unpark(Thread.currentThread());
//
//
//        Thread thread = new Thread(() -> {
//            System.out.println("child begin");
//            LockSupport.park();
//            System.out.println("child end");
//
//        });
//
//        thread.start();
//        Thread.sleep(100);
//        System.out.println("main");
////
//        LockSupport.unpark(thread);

        /**park方法测试**/
        ThreadPark threadPark = new ThreadPark();
        Thread thread = new Thread(threadPark);
        thread.start();
        Thread.sleep(100);
        System.out.println(thread.getName() + ":" + thread.getState());
        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getState());

        /**wait 方法测试**/
        Object lock = new Object();
        ThreadWait threadWait = new ThreadWait(lock);
        Thread thread1 = new Thread(threadWait);
        thread1.start();
        Thread.sleep(100);
        System.out.println(thread1.getName() + ":" + thread1.getState());
        threadWait.release();
        Thread.sleep(100);
        System.out.println(thread1.getName() + ":" + thread1.getState());

//        Thread.sleep(100);
//        System.out.println(thread1.getName() + ":" + thread1.getState());


        NormalThread normalThread = new NormalThread();
        Thread thread2 = new Thread(normalThread);
        thread2.start();
        thread2.join();
        Thread.sleep(100);
        System.out.println(thread2.getName() + ":" + thread2.getState());


    }
}

class ThreadPark implements Runnable {

    @Override
    public void run() {
        System.out.println("park线程起来了");
        LockSupport.park();
        System.out.println("park线程完成");
    }
}

class ThreadWait implements Runnable {
    private Object lock;

    public ThreadWait(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("wait线程起来了");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("wait线程完成");
    }

    public void release() {
        synchronized (lock) {
            lock.notify();
        }
    }

}

class NormalThread implements Runnable {
    @Override
    public void run() {
        System.out.println("正常线程开始自旋");
        while (true) {

        }
    }
}
