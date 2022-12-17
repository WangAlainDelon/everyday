package design.patterns.dp5_singleton;

public class SingletonTest {
    /**
     * 单例模式： 确保一个类只有一个实例，并提供一个全局访问点
     * 使用单例的时候一定要注意Java的版本，如果小于Java5，双检查锁会失效，如果小于1.2单例的实例会被垃圾回收器给回收
     * 自定义类加载的时候要注意不要用不同的内加载去加载，这样也有可能造成多个实例
     *
     *
     *  什么方法可以攻破单例？  反射和序列化
     *  枚举可以防止反射攻破单例模式和序列化的攻击，不用枚举的话需要自己写一个readResolve方法。
     */


    public static void main(String[] args) {

        AyncSingleton instance = AyncSingleton.getInstance();

    }
}
