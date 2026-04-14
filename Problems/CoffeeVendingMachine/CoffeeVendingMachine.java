package Problems.CoffeeVendingMachine;

import Problems.CoffeeVendingMachine.Coffee.Coffee;
import Problems.CoffeeVendingMachine.State.DispenseState;
import Problems.CoffeeVendingMachine.State.IdleState;
import Problems.CoffeeVendingMachine.State.MachineState;
import Problems.CoffeeVendingMachine.State.PayMoneyState;
import Problems.CoffeeVendingMachine.State.SelectCoffeeState;
import Problems.CoffeeVendingMachine.State.SelectCondimentState;

public class CoffeeVendingMachine implements MachineState {
    
    private Inventory inventory;
    private MachineState currentState;

    private MachineState idleState;
    private MachineState selectCoffeeState;
    private MachineState selectCondimentState;
    private MachineState paymentState;
    private MachineState dispensingState;

    Coffee coffee;

    private static volatile CoffeeVendingMachine INSTANCE;

    private CoffeeVendingMachine() {
        this.inventory = new Inventory();
        this.idleState = new IdleState(this);
        this.selectCoffeeState = new SelectCoffeeState(this);
        this.selectCondimentState = new SelectCondimentState(this);
        this.paymentState = new PayMoneyState(this);
        this.dispensingState = new DispenseState(this);
        this.currentState = idleState;
    }

    public static CoffeeVendingMachine getInstance() {
        if (INSTANCE == null) {
            synchronized (CoffeeVendingMachine.class) {
                if (INSTANCE == null) {
                    INSTANCE = new CoffeeVendingMachine();
                }
            }
        }
        return INSTANCE;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setState(MachineState state) {
        this.currentState = state;
    }

    public MachineState getIdleState() {
        return idleState;
    }

    public MachineState getSelectCoffeeState() {
        return selectCoffeeState;
    }

    public MachineState getSelectCondimentState() {
        return selectCondimentState;
    }

    public MachineState getPaymentState() {
        return paymentState;
    }

    public MachineState getDispensingState() {
        return dispensingState;
    }

    @Override
    public void start() {
        currentState.start();
        inventory.displayCoffeeInventory();
    }

    @Override
    public void selectCoffee(Ingredient coffeeType) {
        currentState.selectCoffee(coffeeType);
        inventory.displayCondimentInventory();
    }

    @Override
    public void addCondiment(Ingredient condimentType) {
        currentState.addCondiment(condimentType);
    }

    @Override
    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
        dispenseCoffee();
    }

    @Override
    public void dispenseCoffee() {
        currentState.dispenseCoffee();
    }

    @Override
    public void cancel() {
        currentState.cancel();
    }

    public void doneCondimentSelection() {
        setState(paymentState);
        System.out.println("Condiment selection done. Please insert: $" + coffee.getPrice());
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void restockIngredient(Ingredient ingredient, int quantity) {
        inventory.addIngredient(ingredient, quantity);
    }
    
}
