package design.patterns.proxy.dynamic.cglib.exten;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicCGLibHandler implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before");
        Object re = methodProxy.invokeSuper(o, objects);
        System.out.println("after");
        return re;
    }
}
