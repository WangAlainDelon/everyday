package design.patterns.proxy.dynamic.jdk;

public class JdkProxyTest {

    // JDK动态代理原理：

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
        //定义一个主题
        Subject subject = new RealSubject();
        //定义一个Handler
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(subject);
        //定义主题的代理
        Subject proxy = DynamicProxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), myInvocationHandler);
        /*Subject proxyInstance = SubjectDynamicProxy.newProxyInstance(subject);*/
        proxy.doSomething("hello");
    }
}
