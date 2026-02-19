package IteratorPattern.Menus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DinnerMenu implements Menu {
    
    Map<String, MenuItem> items;

    public DinnerMenu() {
        items = new HashMap<>();
        init();
    }

    private void init() {
        addItem("Grilled Salmon", false, 15.99);
        addItem("Paneer Tikka Masala", true, 13.49);
        addItem("Steak with Mashed Potatoes", false, 18.99);
        addItem("Vegetable Stir Fry", true, 12.79);
        addItem("Chicken Biryani", false, 14.49);
        addItem("Mushroom Risotto", true, 13.99);
    }

    public boolean addItem(String name, boolean vegetarian, double price) {
        items.put(name, new MenuItem(name, vegetarian, price));
        return true;
    }

    public Iterator<MenuItem> createIterator() {
        return items.values().iterator();
    }

}
