package design.patterns.proxy.dynamic.jdk;

public class RealSubject implements Subject {
    @Override
    public void doSomething(String string) {
        System.out.println("真实主题的业务操作" + string);
    }
}
