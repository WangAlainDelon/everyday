package design.patterns.dp5_singleton;

public class DoubleCheckLockSingleton {

    //确保 是使用的是高版本的Java  低版本的双检查加锁会失效

    private volatile static DoubleCheckLockSingleton doubleCheckLockSingleton;

    private DoubleCheckLockSingleton() {
    }

    public DoubleCheckLockSingleton getDoubleCheckLockSingleton() {
        if (doubleCheckLockSingleton == null) {
            synchronized (DoubleCheckLockSingleton.class) {
                if (doubleCheckLockSingleton == null) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }
}
