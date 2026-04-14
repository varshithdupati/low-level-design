package Problems.CoffeeVendingMachine.factory;

import Problems.CoffeeVendingMachine.Ingredient;
import Problems.CoffeeVendingMachine.Coffee.Coffee;
import Problems.CoffeeVendingMachine.Coffee.Cream;
import Problems.CoffeeVendingMachine.Coffee.Milk;
import Problems.CoffeeVendingMachine.Coffee.Steam;
import Problems.CoffeeVendingMachine.Coffee.Sugar;

public class CondimentFactory {
    
    public static Coffee createCondiment(Coffee coffee,Ingredient type) {
        switch (type) {
            case Milk:
                return new Milk(coffee);
            case Sugar:
                return new Sugar(coffee);
            case Cream:
                return new Cream(coffee);
            case Steam:
                return new Steam(coffee);
            default:
                throw new IllegalArgumentException("Unknown condiment type: " + type);
        }
    }
}
