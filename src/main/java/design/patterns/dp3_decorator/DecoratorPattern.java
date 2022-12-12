package design.patterns.dp3_decorator;


public class DecoratorPattern {
    /**
     * 装饰者定义：动态的将责任附加到对象上，若要扩展功能，装饰者提供了比继承更有弹性的替代方案。
     * 装饰者和被装饰者必须是同一类型，也就是有共同的超类，这里仅仅是利用继承达到类型匹配，
     * 而不是利用继承获得行为。如果说装饰者与组件没有同一个超类，那么类型不一致，
     * 就没有办法做层层包装，类型一致是层层包装实现的根基，然后将装饰者与组件组合，这样就能获得新的行为。
     * <p>
     * <p>
     * 设计原则5（非常的重要）：就是开闭原则，类应该对扩展开放，对修改关闭。
     * 遵循开闭原则的要求：遵循开闭原则会引入新的抽象层次，增加代码的复杂度，而我们只需要关注设计中最有可能改变的地方，然后应用开闭原
     * <p>
     * 背景：咖啡店卖各种咖啡，根据调料不一样就会有不同价格的咖啡饮品可选，那么对应的咖啡饮品价格也不一样。
     * 对象：
     * Component
     * ConcreteComponent
     * Decorator
     * ConcreteDecorator
     */


    public static void main(String[] args) {
        //我先点一杯Espresso的饮料，然后往里面加一点
        Espresso espresso = new Espresso();
        System.out.println("一杯 Espresso的价格:" + espresso.cost());

        Mocha mocha = new Mocha(espresso);
        System.out.println("一杯加Mocha Espresso的价格：" + mocha.cost());

    }
}
