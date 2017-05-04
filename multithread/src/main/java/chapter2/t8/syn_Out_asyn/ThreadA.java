package chapter2.t8.syn_Out_asyn;

/**
 * @author nickChen
 * @create 2017-04-20 15:40.
 */
public class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            list.add("threadA"+i);
        }
    }
}
