package FactoryPattern.PizzaFactory;

import FactoryPattern.Pizzas.Pizza;
import FactoryPattern.Pizzas.NYVeggiePizza;
import FactoryPattern.Pizzas.NYCheesePizza;
import FactoryPattern.Pizzas.NYClamPizza;

public class NYPizzaFactory implements PizzaFactory {
    
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")) {
            pizza = new NYCheesePizza();
        }
        else if(type.equals("veggie")) {
            pizza = new NYVeggiePizza();
        }
        else if(type.equals("clam")) {
            pizza = new NYClamPizza();
        }
        return pizza;
    }
    
}
