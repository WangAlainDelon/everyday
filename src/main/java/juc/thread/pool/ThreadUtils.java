package juc.thread.pool;

public class ThreadUtils {

    static void createThread() {
        for (int i = 0; i < 100; i++) {
            new Thread(new Task0()).start();
        }
    }
}
