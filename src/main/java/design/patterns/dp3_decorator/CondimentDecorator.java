package design.patterns.dp3_decorator;

// 抽象的装饰者类 调料都要继承它
public abstract class CondimentDecorator extends Beverage {

    //所有的饮料的调料必须重新实现这个描述的方法
    public abstract String getDescription();
}
