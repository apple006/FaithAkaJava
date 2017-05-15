package designpattern;

/**
 * 最安全快速的懒汉式单例
 * 参考资料：http://wosyingjun.iteye.com/blog/2292883
 * Created by nickChenyx on 2017/4/14.
 */
public class Singleton {
    /**
     * 使用 volatile 的原因是可以保证线程在本地不会存有 instance 的副本，每次都是去主内存中读取。
     * 这里使用volatile的一个主要原因就是volatile可以禁止JVM指令重排序。
     * instance=new Singleton() 这并非是一个原子性质的操作，事实上在JVM中做了如下三件事：
     * 1. 给instance分配内存
     * 2. 调用构造函数初始化成员变量
     * 3. 将instance对象指向分配的内存（此步骤完成instance即为非空）
     * 但是在 JVM 的即时编译器中存在指令重排序的优化。也就是说上面的第二步和第三步的顺序是不能保证的，
     * 最终的执行顺序可能是 1-2-3 也可能是 1-3-2。如果是后者，则在 3 执行完毕、2 未执行之前，被线程二抢占了，
     * 这时 instance 已经是非 null 了（但却没有初始化），所以线程二会直接返回 instance，然后使用，然后顺理成章地报错。
     */
    private volatile static Singleton instance;

    /**
     * 禁止了new 操作，只能通过静态方法来获取实例
     */
    private Singleton (){}

    /**
     * @return
     *          Singleton 实例
     */
    public static Singleton getSingleton() {
        // 先判断是否为空，这样可以排除大多数情况，直接获取到实例
        if (instance == null) {
            // 有可能两个函数都同时判断为空，这时需要使用 synchronized 代码块，只允许 Singleton 的一个对象通过
            synchronized (Singleton.class) {
                // 排队进入代码块之后，要先确认一下实例有没有产生，
                // 因为同时竞争的几个线程会先后进入这个代码块，后来者要先检查前者有没有完成实例创建
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
