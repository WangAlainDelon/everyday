package design.patterns.dp4_factory.simple;

import design.patterns.dp4_factory.CheesePizza;
import design.patterns.dp4_factory.GreekPizza;
import design.patterns.dp4_factory.PepperoniPizza;
import design.patterns.dp4_factory.Pizza;

public class SimplePizzaFactory {

    /**
     * 简单工厂不是一个设计模式，而是一个编程习惯，就是把对象的创建提到了一个简单的工厂类里面去了而已。
       简单的工厂我只有一个工厂，生产不出多种口味的披萨，而工厂方法我有多个工厂，不同的工厂子类可以生产多种口味的披萨。
     */



    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("greek")) {
            pizza = new GreekPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        }
        return pizza;
    }
}
