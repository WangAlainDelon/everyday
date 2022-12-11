package design.patterns.dp4_factory.abstrac.factory;

import design.patterns.dp4_factory.abstrac.pizza.NYStyleCheesePizza;
import design.patterns.dp4_factory.abstrac.pizza.Pizza;

public class NYPizzaStore extends AbstactPizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza = null;

        switch (type) {
            case "cheese":
                pizza = new NYStyleCheesePizza();
                break;
//            case "veggie":
//                pizza = new NYStyleVeggiePizza(ingredientFactory);
//                break;
//            case "clam":
//                pizza = new NYStyleClamPizza(ingredientFactory);
//                break;
//            case "pepperoni":
//                pizza = new NYStylePepperoniPizza(ingredientFactory);
//                break;
        }
        return pizza;
    }
}
