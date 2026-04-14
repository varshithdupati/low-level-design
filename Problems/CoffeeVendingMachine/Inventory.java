package Problems.CoffeeVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    
    private Map<Ingredient, Integer> ingredientStock;
    private List<Ingredient> coffeeMenu;
    private List<Ingredient> condimentMenu;

    public Inventory() {
        this.ingredientStock = new HashMap<>();
        this.coffeeMenu = new ArrayList<>();
        this.condimentMenu = new ArrayList<>();
        initializeMenu();
    }

    private void initializeMenu() {
        // Initialize coffee menu
        coffeeMenu.add(Ingredient.Cappuccino);
        coffeeMenu.add(Ingredient.Latte);
        coffeeMenu.add(Ingredient.Espresso);

        // Initialize condiment menu
        condimentMenu.add(Ingredient.Milk);
        condimentMenu.add(Ingredient.Sugar);
        condimentMenu.add(Ingredient.Cream);
        condimentMenu.add(Ingredient.Steam);
    }

    public void addIngredient(Ingredient ingredient, int quantity) {
        this.ingredientStock.put(ingredient, this.ingredientStock.getOrDefault(ingredient, 0) + quantity);
    }

    public void useIngredient(Ingredient ingredient, int quantity) {
        int currentStock = this.ingredientStock.getOrDefault(ingredient, 0);
        currentStock -= quantity;
        currentStock = Math.max(currentStock, 0); // Ensure stock doesn't go negative
        this.ingredientStock.put(ingredient, currentStock);
    }

    public int getIngredientStock(Ingredient ingredient) {
        return this.ingredientStock.getOrDefault(ingredient, 0);
    }

    public void displayCoffeeInventory() {
        System.out.println("Coffee Menu:");
        for (Ingredient coffee : coffeeMenu) {
            System.out.println(coffee + ": " + getIngredientStock(coffee) + " units");
        }
    }

    public void displayCondimentInventory() {
        System.out.println("Condiment Menu:");
        for (Ingredient condiment : condimentMenu) {
            System.out.println(condiment + ": " + getIngredientStock(condiment) + " units");
        }
    }

}
