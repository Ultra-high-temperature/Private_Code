package javaTest;

public class SynchronizedTest implements Runnable{
    private static Integer count = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            Thread thread = new Thread(new SynchronizedTest());
            thread.start();
        }
        System.out.println(count);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized(SynchronizedTest.class){
                count++;
            }
        }
    }
}
