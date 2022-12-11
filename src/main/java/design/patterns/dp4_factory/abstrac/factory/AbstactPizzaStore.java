package design.patterns.dp4_factory.abstrac.factory;


import design.patterns.dp4_factory.abstrac.pizza.Pizza;

public abstract class AbstactPizzaStore {

    /**
     *   工厂方法模式的定义： 定义一个创建对象的接口，由子类决定要实例化的类是哪一个，这就工厂方法的特点，
     *   把类的实例化推迟到子类。把产品的实现从使用中解耦。

     */


    public Pizza orderPizza(String type) {
        Pizza pizza;
        //orderPizza通过传入type类型，使用工厂完成创建
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 工厂对象功能移到这里
     *
     * @param type
     * @return PIZZA
     */
    protected abstract Pizza createPizza(String type);
}
