package DecoratorPattern;

public class Soy extends CondimentDecorator {

    Soy(Beverage beverage) {
        this.beverage = beverage;
        this.name = "Soy";
    }

    public int cost() {
        return (beverage.cost() + 1);
    }
    
}
