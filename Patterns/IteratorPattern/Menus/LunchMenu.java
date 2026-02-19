package IteratorPattern.Menus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LunchMenu implements Menu {
    
    List<MenuItem> items;

    public LunchMenu() {
        items = new ArrayList<>();
        init();
    }

    private void init() {
        addItem("Grilled Chicken Sandwich", false, 10.99);
        addItem("Margherita Pizza", true, 11.49);
        addItem("Veggie Burger", true, 9.79);
        addItem("Pasta Alfredo", true, 12.29);
        addItem("Caesar Salad", false, 8.99);
        addItem("Tomato Soup", true, 6.49);
    }

    public boolean addItem(String name, boolean vegetarian, double price) {
        items.add(new MenuItem(name, vegetarian, price));
        return true;
    }

    public Iterator<MenuItem> createIterator() {
        return items.iterator();
    }

}
