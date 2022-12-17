package design.patterns.dp5_singleton;

import java.io.Serializable;

public class AyncSingleton  {

    //再不考虑性能的情况下可以直接使用这种同步的单例模式，就是说他的性能可能最差
    private AyncSingleton() {

    }

    private static AyncSingleton ayncSingleton;

    public static synchronized AyncSingleton getInstance() {
        if (ayncSingleton == null) {
            ayncSingleton = new AyncSingleton();
        }
        return ayncSingleton;
    }


}
