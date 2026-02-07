package FactoryPattern.PizzaFactory;

import FactoryPattern.Pizzas.Pizza;

public interface PizzaFactory {
    
    Pizza createPizza(String type);

}
