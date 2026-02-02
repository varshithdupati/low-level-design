package DecoratorPattern;

public class Main {
    
    public static void main(String[] args) {

        Beverage beverage1 = new DarkRoast();
        beverage1 = new WhipCream(beverage1);
        beverage1 = new WhipCream(beverage1);
        System.out.println(beverage1.getDescription() + " - $" + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Soy(beverage2);
        System.out.println(beverage2.getDescription() + " - $" + beverage2.cost());

    }

}
