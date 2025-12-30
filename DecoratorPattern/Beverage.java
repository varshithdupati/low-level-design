package DecoratorPattern;

public abstract class Beverage {
    
    String name;

    public String getDescription() {
        return name;
    }

    abstract int cost();

}
