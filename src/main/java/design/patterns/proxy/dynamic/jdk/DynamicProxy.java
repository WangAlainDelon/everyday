package design.patterns.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) {
        //执行目标，并返回结果,
        return (T) Proxy.newProxyInstance(loader, interfaces, h);
    }

}
