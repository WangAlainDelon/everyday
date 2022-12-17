package design.patterns.dp5_singleton;

public class EagerSingleton {

    //静态初始化器中去保证了单例，但是这个单例没有被用到也会创建，而我们希望的是用到才创建
    //这个版本最大的缺点就是不能有其他的实例变量，因为getEagerSingleton没有同步。会有线程安全的问题

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton() {
    }

    public EagerSingleton getEagerSingleton() {
        return eagerSingleton;
    }
}
