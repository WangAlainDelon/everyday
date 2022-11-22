package design.patterns.proxy.stati;

public class SubjectProxy implements Subject {
    //要代理哪个实现类
    private Subject subject = null;

    //被默认代理者
    public SubjectProxy() {

        this.subject = new RealSubject();
    }

    //通过构造函数传递代理者
    public SubjectProxy(Subject subject) {

        this.subject = subject;
    }

    @Override
    public void request() {
        this.before();
        this.subject.request();
        this.after();
    }

    //预处理
    public void before() {
        System.out.println("预处理");
    }

    //善后处理
    public void after() {
        System.out.println("善后处理");
    }
}
