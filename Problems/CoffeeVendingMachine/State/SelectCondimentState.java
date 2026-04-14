package Problems.CoffeeVendingMachine.State;

import Problems.CoffeeVendingMachine.CoffeeVendingMachine;
import Problems.CoffeeVendingMachine.Ingredient;
import Problems.CoffeeVendingMachine.Coffee.Coffee;
import Problems.CoffeeVendingMachine.factory.CondimentFactory;

public class SelectCondimentState implements MachineState {

    private CoffeeVendingMachine machine;

    public SelectCondimentState(CoffeeVendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void start() {
        System.out.println("Machine is already started. Please add condiments.");
    }

    @Override
    public void selectCoffee(Ingredient coffeeType) {
        System.out.println("A coffee is already selected.");
    }

    @Override
    public void addCondiment(Ingredient condimentType) {
        try {
            Coffee coffeeWithCondiment = CondimentFactory.createCondiment(machine.getCoffee(), condimentType);
            machine.setCoffee(coffeeWithCondiment);
            System.out.println(condimentType + " added. You can add more condiments or insert money.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Please add condiments first.");
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please add condiments first.");
    }

    @Override
    public void cancel() {
        System.out.println("Cancelling condiment selection.");
        machine.setState(machine.getIdleState());
    }

}