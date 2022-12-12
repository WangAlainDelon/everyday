package design.patterns.dp4_factory.abstrac;

import design.patterns.dp4_factory.abstrac.factory.AbstactPizzaStore;
import design.patterns.dp4_factory.abstrac.factory.NYPizzaStore;
import design.patterns.dp4_factory.abstrac.pizza.Pizza;


public class TestAbstractFactory {

    /**
     * 第六个设计原则：依赖倒置原则，要依赖抽象，不要依赖具体类。
     * 这里和针对接口编程的原则很像，但是它更强调抽象。这个原则说明了不能让高层组件依赖底层组件，而两者都依赖于抽象。
     * <p>
     * 在这里PizzaStore是高层组件，Pizza是底层组件 他们不应该直接去依赖。
     * <p>
     * 抽象工厂：提供一个接口，用于创建相关或依赖对象的家族，而不需要明确指定具体的类。
     * <p>
     * 抽象工厂允许客户使用抽象接口来创建一组相关的产品，这样客户就从具体的产品中被解耦。
     * <p>
     * 所以这里的具体产品Pizza变成了抽象
     */

    public static void main(String[] args) {
        //获得一个Pizza店
        AbstactPizzaStore nyStyleCheesePizza = new NYPizzaStore();
        //创建一种风味的Pizza
        Pizza cheese = nyStyleCheesePizza.orderPizza("cheese");

        cheese.prepare();
        cheese.bake();
        cheese.cut();
    }
}
