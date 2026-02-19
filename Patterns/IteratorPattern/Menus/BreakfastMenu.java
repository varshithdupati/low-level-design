package IteratorPattern.Menus;

import java.util.Iterator;
import IteratorPattern.Iterators.BreakfastMenuIterator;

public class BreakfastMenu implements Menu {
    
    final int maxItems;
    int itemsCount;
    MenuItem[] items;

    public BreakfastMenu() {
        maxItems = 10;
        itemsCount = 0;
        items = new MenuItem[maxItems];
        init();
    }

    private void init() {
        addItem("Classic Pancakes", true, 6.99);
        addItem("Veggie Omelette", true, 7.49);
        addItem("Breakfast Burrito", false, 8.99);
        addItem("French Toast", true, 6.79);
        addItem("Sausage & Eggs", false, 9.49);
        addItem("Fruit Bowl", true, 5.49);
    }

    public boolean addItem(String name, boolean vegetarian, double price) {
        if (itemsCount >= maxItems) {
            return false;
        }
        items[itemsCount++] = new MenuItem(name, vegetarian, price);
        return true;
    }

    public Iterator<MenuItem> createIterator() {
        return new BreakfastMenuIterator(items);
    }

}
