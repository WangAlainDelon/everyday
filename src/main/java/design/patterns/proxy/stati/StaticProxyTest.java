package design.patterns.proxy.stati;

public class StaticProxyTest {
    public static void main(String[] args) {
        /**静态代理就是在运行前就创建好了代理的对象，而动态代理是在运行时才创建动态代理的对象*/
        Subject subject = new RealSubject();
        SubjectProxy proxy = new SubjectProxy(subject);
        proxy.request();
    }
}
