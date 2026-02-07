package FactoryPattern.PizzaStore;

import FactoryPattern.PizzaFactory.PizzaFactory;
import FactoryPattern.Pizzas.Pizza;

public class PizzaStore {
    
    PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public void orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

}
