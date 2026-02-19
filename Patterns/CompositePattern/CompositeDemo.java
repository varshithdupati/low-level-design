package CompositePattern;

public class CompositeDemo {
    
    public static void main(String[] args) {
        
        MenuComponent allMenus = new Menu("All Menus");
        
        MenuComponent breakfastMenu = new Menu("Breakfast Menu");
        MenuComponent lunchMenu = new Menu("Lunch Menu");
        MenuComponent dinnerMenu = new Menu("Dinner Menu");
        MenuComponent dessertMenu = new Menu("Dessert Menu");

        allMenus.add(breakfastMenu);
        allMenus.add(lunchMenu);
        allMenus.add(dinnerMenu);

        breakfastMenu.add(new MenuItem("Classic Pancakes", true, 6.99));
        breakfastMenu.add(new MenuItem("Veggie Omelette", true, 7.49));
        breakfastMenu.add(new MenuItem("Breakfast Burrito", false, 8.99));

        lunchMenu.add(new MenuItem("Grilled Chicken Sandwich", false, 10.99));
        lunchMenu.add(new MenuItem("Margherita Pizza", true, 11.49));
        lunchMenu.add(new MenuItem("Veggie Burger", true, 9.79));

        dinnerMenu.add(new MenuItem("Grilled Salmon", false, 15.99));
        dinnerMenu.add(new MenuItem("Paneer Tikka Masala", true, 13.49));
        dinnerMenu.add(new MenuItem("Mushroom Risotto", true, 13.99));

        lunchMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("Chocolate Brownie", true, 5.99));
        dessertMenu.add(new MenuItem("Ice Cream Sundae", true, 4.99));
        dessertMenu.add(new MenuItem("Cheesecake", true, 6.49));

        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
        
    }

}
