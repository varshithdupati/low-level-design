package DecoratorPattern;

public class HouseBlend extends Beverage {

    HouseBlend() {
        this.name = "House Blend";
    }

    public int cost() {
        return 12;
    }
    
}
