package DecoratorPattern;

public abstract class CondimentDecorator extends Beverage {
    
    Beverage beverage;
    String name;

    public String getDescription() {
        return (beverage.getDescription() + ", " + name);
    }

}
