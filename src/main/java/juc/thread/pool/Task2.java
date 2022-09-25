package juc.thread.pool;

public class Task2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task2任务开始");
        try {
            Thread.sleep(5000);
            System.out.println("task2线程的状态：" + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task2任务结束");
    }
}
