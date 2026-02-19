package IteratorPattern.Menus;

public class MenuItem {

    String name;
    boolean vegetarian;
    double price;

    MenuItem(String name, boolean vegetarian, double price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", vegetarian: " + vegetarian + ", $" + price;
    }
    
}
