package juc.thread.pool;

public class Task1 implements Runnable {
    @Override
    public void run() {
        System.out.println("Task1任务开始");
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "线程的状态：" + Thread.currentThread().getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task1任务结束");
    }
}
