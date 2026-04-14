package Problems.CoffeeVendingMachine.State;

import Problems.CoffeeVendingMachine.Ingredient;

public interface MachineState {
    
    void start();
    void selectCoffee(Ingredient coffeeType);
    void addCondiment(Ingredient condimentType);
    void insertMoney(double amount);
    void dispenseCoffee();
    void cancel();

}
