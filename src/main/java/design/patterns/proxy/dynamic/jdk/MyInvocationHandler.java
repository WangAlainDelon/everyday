package design.patterns.proxy.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {
    //这个类中持有一个被代理对象的实例target
    private Object target = null;

    //通过构造函数传递一个对象
    public MyInvocationHandler(Object o) {
        this.target = o;
    }

    //代理方法,非常简单，所有通过动态代理实现的方法全部通过invoke方法调用。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在这里就可以织入其他的逻辑


        //执行被代理的方法
        return method.invoke(target, args);
    }
}
