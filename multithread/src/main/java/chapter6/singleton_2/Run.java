package chapter6.singleton_2;

/**
 * @author nickChen
 * @create 2017-04-25 11:03.
 */
public class Run {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new MyThread().start();
        }
    }
}
