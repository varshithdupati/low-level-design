package IteratorPattern;

import IteratorPattern.Menus.BreakfastMenu;
import IteratorPattern.Menus.DinnerMenu;
import IteratorPattern.Menus.LunchMenu;

public class MenuDemo {
    
    public static void main(String[] args) {
        Waitress waitress = new Waitress(new BreakfastMenu(), new LunchMenu(), new DinnerMenu());
        waitress.printMenu();
    }

}
