package javaTest;

import com.alibaba.fastjson.parser.Feature;

import java.util.concurrent.*;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 15, 10L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(10));
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CountDownLatch main = new CountDownLatch(1);
        CountDownLatch sub = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Future<String> future = executorService.submit(()->{
                try {
                    System.out.println(Thread.currentThread().getId() + "wait");
                    main.await();
                    System.out.println(Thread.currentThread().getId() + "running");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    System.out.println(Thread.currentThread().getId() + "finish");
                    sub.countDown();
                    return Thread.currentThread().getId()+"name";
                }
            });
        }

        main.countDown();
        System.out.println("main thread wait");
        sub.await();
        System.out.println("main thread finish");
    }
}
