package FactoryPattern;

import FactoryPattern.PizzaFactory.NYPizzaFactory;
import FactoryPattern.PizzaFactory.ChicagoPizzaFactory;
import FactoryPattern.PizzaStore.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore pizzaStore1 = new PizzaStore(new NYPizzaFactory());
        pizzaStore1.orderPizza("cheese");
        pizzaStore1.orderPizza("veggie");
        pizzaStore1.orderPizza("clam");
        PizzaStore pizzaStore2 = new PizzaStore(new ChicagoPizzaFactory());
        pizzaStore2.orderPizza("cheese");
        pizzaStore2.orderPizza("veggie");
        pizzaStore2.orderPizza("clam");
    }
}
