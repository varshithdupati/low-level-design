package Problems.CoffeeVendingMachine.State;

import Problems.CoffeeVendingMachine.CoffeeVendingMachine;
import Problems.CoffeeVendingMachine.Ingredient;

public class PayMoneyState implements MachineState {

    private CoffeeVendingMachine machine;

    public PayMoneyState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void start() {
        System.out.println("Already in payment state.");
    }

    @Override
    public void selectCoffee(Ingredient coffeeType) {
        System.out.println("Cannot select coffee while payment is in progress.");
    }

    @Override
    public void addCondiment(Ingredient condimentType) {
        System.out.println("Cannot add condiments while payment is in progress.");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Money $" + amount + " inserted. Please wait for the coffee to be dispensed.");
        machine.setState(machine.getDispensingState());
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Cannot dispense coffee while payment is in progress.");
    }

    @Override
    public void cancel() {
        System.out.println("Payment cancelled. Returning to idle state.");
        machine.setState(machine.getIdleState());
    }
    
}
