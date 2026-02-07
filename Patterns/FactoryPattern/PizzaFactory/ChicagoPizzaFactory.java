package FactoryPattern.PizzaFactory;

import FactoryPattern.Pizzas.Pizza;
import FactoryPattern.Pizzas.ChicagoVeggiePizza;
import FactoryPattern.Pizzas.ChicagoCheesePizza;
import FactoryPattern.Pizzas.ChicagoClamPizza;

public class ChicagoPizzaFactory implements PizzaFactory {
    
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("cheese")) {
            pizza = new ChicagoCheesePizza();
        }
        else if(type.equals("veggie")) {
            pizza = new ChicagoVeggiePizza();
        }
        else if(type.equals("clam")) {
            pizza = new ChicagoClamPizza();
        }
        return pizza;
    }
}
