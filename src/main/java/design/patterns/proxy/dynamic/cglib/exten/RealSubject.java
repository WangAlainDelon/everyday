package design.patterns.proxy.dynamic.cglib.exten;

public class RealSubject extends Subject {
    @Override
    public void doSomething(String string) {
        System.out.println("真实主题的业务操作" + string);
    }
}
