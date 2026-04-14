package Problems.CoffeeVendingMachine.State;

import Problems.CoffeeVendingMachine.CoffeeVendingMachine;
import Problems.CoffeeVendingMachine.Ingredient;

public class IdleState implements MachineState {

    private CoffeeVendingMachine machine;

    public IdleState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void start() {
        System.out.println("Starting the coffee vending machine. Please select a coffee.");
        machine.setState(machine.getSelectCoffeeState());
    }

    @Override
    public void selectCoffee(Ingredient coffeeType) {
        System.out.println("Please start the machine first.");
    }

    @Override
    public void addCondiment(Ingredient condimentType) {
        System.out.println("Please start the machine first.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please start the machine first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please start the machine first.");
    }

    @Override
    public void cancel() {
        System.out.println("No selection made. Staying in idle state.");
    }

}