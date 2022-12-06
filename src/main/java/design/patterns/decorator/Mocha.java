package design.patterns.decorator;

public class Mocha extends CondimentDecorator {
    //用一个实例变量记录饮料，也就是被装饰者
    Beverage beverage;

    //把饮料当做构造器参数，再由构造器将此饮料记录在实例变量中
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }


    //利用委托的做法，得到一个叙述，然后在其后加上调料的叙述
    public String getDescription() {
        return beverage.getDescription() + "，Mocha";
    }

    //首先把调用委托给被装饰者对象，然后再加上Mocha的价钱
    public double cost() {
        return .20 + beverage.cost();
    }
}
