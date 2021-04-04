package javaTest;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static Object o = new Object();

    public static void main0(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 15, 10L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(10));
        for (int i = 0; i < 20; i++) {
            executor.execute(new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));
        }
        System.out.println("000");
    }

    static class errorTest extends Exception{

    }

    static class submitTest implements Callable {
        @Override
        public Object call() throws Exception {
            int[] a = new int[10];
//            System.out.println(""+a[10]);
//            throw new errorTest();
            return a;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 15, 10L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>(10));
        Future<?> submit = executor.submit(new submitTest());
        Object o = submit.get();
        System.out.println();
    }
}
