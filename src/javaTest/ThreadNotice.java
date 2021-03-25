package javaTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThreadNotice {

    static List<Thread> noticeList = new ArrayList();
    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                while (flag) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
//                        synchronized (this){
//                            System.out.println(Thread.currentThread().getName()+"准备wait");
                // this指针指向的是这个Runnable对象，不是外面的Thread对象
//                            this.wait();
//                        }
                System.out.println(Thread.currentThread().getName() + "醒了");
            });
            noticeList.add(thread);
            thread.start();
            synchronized (thread) {
                System.out.println(i + "准备暂停");
                thread.wait();
            }
        }
        flag = false;
        for (int i = 0; i < noticeList.size(); i++) {
            Thread thread = noticeList.get(i);
            System.out.println(i + "准备唤醒");
            synchronized (thread) {
                thread.notify();
            }
        }

    }
}
