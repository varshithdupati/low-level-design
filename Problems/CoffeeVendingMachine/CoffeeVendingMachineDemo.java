package Problems.CoffeeVendingMachine;

public class CoffeeVendingMachineDemo {
    
    public static void main(String[] args) {
        CoffeeVendingMachine machine = CoffeeVendingMachine.getInstance();

        machine.restockIngredient(Ingredient.Cappuccino, 10);
        machine.restockIngredient(Ingredient.Latte, 10);
        machine.restockIngredient(Ingredient.Espresso, 10);
        machine.restockIngredient(Ingredient.Milk, 20);
        machine.restockIngredient(Ingredient.Sugar, 20);
        machine.restockIngredient(Ingredient.Cream, 20);
        machine.restockIngredient(Ingredient.Steam, 20);

        machine.start();
        machine.selectCoffee(Ingredient.Cappuccino);
        machine.addCondiment(Ingredient.Milk);
        machine.addCondiment(Ingredient.Sugar);
        machine.addCondiment(Ingredient.Cream);
        machine.addCondiment(Ingredient.Cream);
        machine.doneCondimentSelection();
        machine.insertMoney(10.0);
    }
}
