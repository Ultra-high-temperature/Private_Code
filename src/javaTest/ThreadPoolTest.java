package javaTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newWorkStealingPool();
//        new ThreadPoolExecutor()
    }
}
