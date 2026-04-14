package Problems.CoffeeVendingMachine.State;

import Problems.CoffeeVendingMachine.CoffeeVendingMachine;
import Problems.CoffeeVendingMachine.Ingredient;
import Problems.CoffeeVendingMachine.Coffee.Coffee;
import Problems.CoffeeVendingMachine.factory.CoffeeFactory;

public class SelectCoffeeState implements MachineState {

    private CoffeeVendingMachine machine;

    public SelectCoffeeState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void start() {
        System.out.println("Machine is already started. Please select a coffee.");
    }

    @Override
    public void selectCoffee(Ingredient coffeeType) {
        try {
            Coffee coffee = CoffeeFactory.createCoffee(coffeeType);
            machine.setCoffee(coffee);
            System.out.println(coffeeType + " selected. Please add condiments if desired.");
            machine.setState(machine.getSelectCondimentState());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
    }

    @Override
    public void addCondiment(Ingredient condimentType) {
        System.out.println("Please select a coffee first.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please select a coffee first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please select a coffee first.");
    }

    @Override
    public void cancel() {
        System.out.println("No selection made. Returning to idle state.");
        machine.setState(machine.getIdleState());
    }
    
}
