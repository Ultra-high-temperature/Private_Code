package javaTest;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest implements Runnable{
    private static Integer count = 0;
    // 使用i++时并不能保证这是原子操作，因为有三步，取值，运算，赋值
    private static volatile int count2=0;

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SynchronizedTest());
            thread.start();
        }
        Thread.sleep(10000);
        System.out.println(count2);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            count2++;
        }
        System.out.println("当前线程已结束"+Thread.currentThread().getId()+" "+count2);
    }

    public void f1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("Hello World.");
        }
    }

    public synchronized void f2() {
        System.out.println("Hello World.");
    }
}
