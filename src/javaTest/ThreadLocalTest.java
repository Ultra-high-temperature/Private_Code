package javaTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {
    private ThreadLocal t1;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.printf(String.valueOf(Thread.currentThread().getId()));
            }
        });
    }
}
