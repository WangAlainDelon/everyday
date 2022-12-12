package design.patterns.dp4_factory.method;

import design.patterns.dp4_factory.CheesePizza;
import design.patterns.dp4_factory.GreekPizza;
import design.patterns.dp4_factory.PepperoniPizza;
import design.patterns.dp4_factory.Pizza;

public class NYPizzaStore extends AbstactPizzaStore {
    @Override
    protected Pizza createPizza(String type) {
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
