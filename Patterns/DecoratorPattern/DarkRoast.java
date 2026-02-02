package DecoratorPattern;

public class DarkRoast extends Beverage {
    
    DarkRoast() {
        this.name = "Dark Roast";
    }

    public int cost() {
        return 10;
    }

}
