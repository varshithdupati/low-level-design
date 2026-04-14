package Problems.CoffeeVendingMachine.factory;

import Problems.CoffeeVendingMachine.Ingredient;
import Problems.CoffeeVendingMachine.Coffee.Cappuccino;
import Problems.CoffeeVendingMachine.Coffee.Coffee;
import Problems.CoffeeVendingMachine.Coffee.Espresso;
import Problems.CoffeeVendingMachine.Coffee.Latte;

public class CoffeeFactory {
    
    public static Coffee createCoffee(Ingredient type) {
        switch (type) {
            case Cappuccino:
                return new Cappuccino();
            case Latte:
                return new Latte();
            case Espresso:
                return new Espresso();
            default:
                throw new IllegalArgumentException("Unknown coffee type: " + type);
        }
    }

}
