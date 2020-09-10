package hn;

import java.util.ArrayList;
import java.util.List;

public class ThreadDemo implements Runnable {

    private Thread threadDemo;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("现在是第{}次",i);
        }
    }

    public void start() {
        if(null==threadDemo){
            threadDemo=new Thread(this,"啥玩意啊");
        }
        if (!threadDemo.isAlive()) {
            threadDemo.start();
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        List list=new ArrayList<>();
        threadDemo.start();
    }
}
