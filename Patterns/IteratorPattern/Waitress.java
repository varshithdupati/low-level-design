package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import IteratorPattern.Menus.Menu;
import IteratorPattern.Menus.MenuItem;

public class Waitress {
    
    List<Menu> menus;

    Waitress(Menu breakfastMenu, Menu lunchMenu, Menu dinnerMenu) {
        menus = new ArrayList<>();
        menus.add(breakfastMenu);
        menus.add(lunchMenu);
        menus.add(dinnerMenu);
    }

    public void printMenu() {
        System.out.println("Breakfast:");
        System.out.println("------------");
        print(menus.get(0));
        System.out.println("------------\n");
        System.out.println("Lunch:");
        System.out.println("------------");
        print(menus.get(1));
        System.out.println("------------\n");
        System.out.println("Dinner:");
        System.out.println("------------");
        print(menus.get(2));
        System.out.println("------------\n");
    }

    private void print(Menu menu) {
        Iterator<MenuItem> iterator = menu.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
