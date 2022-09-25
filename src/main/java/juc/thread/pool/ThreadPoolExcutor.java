package juc.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolExcutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //获取机器的线程数
//        System.out.println(Runtime.getRuntime().availableProcessors());

        //



//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(new Task1());
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("耗时：" + (end - start));
//
//        executorService.shutdown();

        // 线程池的确能够提高任务的执行速度，因为并行执行的原因


        //任务的编排


        //如果并行执行
//        ThreadUtils.createThread();

        // 主线程执行任务需要消耗3S
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 子线程执行任务需要五秒

    }
}
