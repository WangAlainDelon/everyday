package design.patterns.proxy.dynamic.cglib.exten;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {

    //CGLIB代理原理：


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DynamicCGLibHandler());
        Subject subject = (Subject) enhancer.create();
        subject.doSomething("ss");
    }
}
