package juc.thread.feature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeatureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //https://zhuanlan.zhihu.com/p/344431341
        // CompletableFuture API
        // supplyAsync 和 runAsync 的区别是：
        // supply开头：这种方法，可以返回异步线程执行之后的结果
        //run开头：这种不会返回结果，就只是执行线程任务

        // 获取结果
//        public T    get()
//        public T    get(long timeout, TimeUnit unit)
//        public T    getNow(T valueIfAbsent)
//        public T    join()  join() 返回计算的结果或者抛出一个unchecked异常(CompletionException)，而get() 返回一个具体的异常.


        // CompletableFuture跟Feature的get方法都会阻塞主线程，但是CompletableFuture 有回调不会阻塞主线程。
        // CompletableFuture 如何对多个任务进行编排
        // 三个任务返回结果没有任何的关联，可以各自并行去执行。各自处理各自的结果。
        // 三个任务结果需要汇总，并行去执行
        // 三个任务中有一个任务是需要等待前面两个任务的结果，前面两个任务可以并行执行
        // 三个任务串行化执行。


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 1.将三个依赖的任务串行化异步执行  thenApplyAsync会将任务交给线程池中的线程执行 thenApply会交给Main线程执行这个很危险
//        Integer integer1 = CompletableFuture.supplyAsync(() -> {
//            return 1;
//        }, executorService).thenApplyAsync(u -> {
//            return u + 1;
//        }, executorService).thenApplyAsync(o -> {
//            return o + 1;
//        }, executorService).get();
//        System.out.println(integer1);

        //2.三个任务相互独立互不依赖  thenCompose跟thenApply没啥区别
//        Integer join = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("任务1");
//            return 1;
//        }, executorService).thenComposeAsync(integer -> {
//            System.out.println("任务2");
//            CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
//                int re = integer + 1;
//                return re;
//            });
//            return integerCompletableFuture;
//        }, executorService).join();
//        System.out.println(join);
        //3.三个任务并行运行最后组合结果
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("任务1");
//            return 1;
//        }, executorService).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("任务2");
//            return 1;
//        }, executorService), (integer, integer2) -> integer + integer2).thenCombineAsync(CompletableFuture.supplyAsync(() -> {
//            System.out.println("任务3");
//            return 1;
//        }, executorService), (integer, integer2) -> integer + integer2);
//        System.out.println(future1.join());
//        System.out.println(future1.get());

        //4.当所有任务完成后返回一个future

        //5.获取率先完成的任务






//        Integer join = CompletableFuture.supplyAsync(() -> {
//            System.out.println("线程号为***" + Thread.currentThread().getId());
//            int i = 5;
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("---------" + i);
//            return i;
//        }, executorService).thenCombine(CompletableFuture.supplyAsync(() -> {
//            //thenCombine
//            System.out.println("谁先执行");
//            return 11;
//        }, executorService), (integer, integer2) -> integer + integer2).join();


//        CompletableFuture<Integer> integerCompletableFuture = (CompletableFuture<Integer>) join;
//                .whenComplete((r, e) -> {
////            whenComplete第一个参数是结果，第二个参数是异常，他可以感知异常，无法返回默认数据
//            System.out.println("执行完毕，结果是---" + r + "异常是----" + e);
//            System.out.println("继续执行子线程任务");
//        }).exceptionally(u -> {
////            exceptionally只有一个参数是异常类型，他可以感知异常，同时返回默认数据10
//            return 10;
////            handler既可以感知异常，也可以返回默认数据，是whenComplete和exceptionally的结合
//        }).handle((r, e) -> {
//            if (r != null) {
//                return r;
//            }
//            if (e != null) {
//                return 0;
//            }
//            return 0;
//        });

//        Integer integer = integerCompletableFuture.get();
//        System.out.println(join);
        System.out.println("主线程的任务完成");

    }
}

