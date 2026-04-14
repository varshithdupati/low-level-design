package Problems.CoffeeVendingMachine.Coffee;

public abstract class Condiment extends Coffee {

    Coffee coffee;
    String name;
    double price;

    public String getName() {
        return coffee.getName() + " with " + name;
    }

    public double getPrice() {
        return coffee.getPrice() + price;
    }

}
