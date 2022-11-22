package design.patterns.proxy.dynamic.cglib.exten;

import design.patterns.proxy.dynamic.cglib.inter.CGLibFactory;
import design.patterns.proxy.dynamic.cglib.inter.ISomeService;
import design.patterns.proxy.dynamic.cglib.inter.ISomeServiceImp;
import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new DynamicCGLibHandler());
        Subject subject = (Subject) enhancer.create();
        subject.doSomething("ss");
    }
}
