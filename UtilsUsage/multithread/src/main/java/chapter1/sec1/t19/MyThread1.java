package chapter1.sec1.t19;

import java.util.Random;

/**
 * @author nickChen
 * @create 2017-04-20 9:26.
 */
public class MyThread1 extends Thread {
    @Override
    public void run() {
        long start = System.currentTimeMillis();
        long addResult = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5000; j++) {
                Random random = new Random();
                random.nextInt();
                addResult+=j;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("thread 1 use time="+(end-start)+"ms");
    }
}
