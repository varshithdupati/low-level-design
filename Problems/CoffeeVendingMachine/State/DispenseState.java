package Problems.CoffeeVendingMachine.State;

import Problems.CoffeeVendingMachine.CoffeeVendingMachine;
import Problems.CoffeeVendingMachine.Ingredient;

public class DispenseState implements MachineState {

    private CoffeeVendingMachine machine;

    public DispenseState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void start() {
        System.out.println("Already in dispensing state.");
    }

    @Override
    public void selectCoffee(Ingredient coffeeType) {
        System.out.println("Cannot select coffee while dispensing.");
    }

    @Override
    public void addCondiment(Ingredient condimentType) {
        System.out.println("Cannot add condiments while dispensing.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Cannot insert money while dispensing.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Dispensing coffee...");
        System.out.println("Enjoy your " + machine.getCoffee().getName() + "!");
        machine.setState(machine.getIdleState());
    }

    @Override
    public void cancel() {
        System.out.println("Cancelling dispensing. Returning to idle state.");
        machine.setState(machine.getIdleState());
    }

}