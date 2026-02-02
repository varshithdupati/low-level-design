package DecoratorPattern;

public class Mocha extends CondimentDecorator {

    Mocha(Beverage beverage) {
        this.beverage = beverage;
        this.name = "Mocha";
    }

    public int cost() {
        return (beverage.cost() + 2);
    }
    
}
