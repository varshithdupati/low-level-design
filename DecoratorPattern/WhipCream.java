package DecoratorPattern;

public class WhipCream extends CondimentDecorator {
    
    WhipCream(Beverage beverage) {
        this.name = "Whip Cream";
        this.beverage = beverage;
    }

    public int cost() {
        return (this.beverage.cost() + 3);
    }
    
}
