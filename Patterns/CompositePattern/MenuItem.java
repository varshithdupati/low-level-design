package CompositePattern;

public class MenuItem extends MenuComponent {

    String name;
    boolean vegetarian;
    double price;

    public MenuItem(String name, boolean vegetarian, double price) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVegetarian() {
        return this.vegetarian;
    }

    public double getPrice() {
        return this.price;
    }

    public void print() {
        print("");
    }

    public void print(String indent) {
        String vegLabel = vegetarian ? "[V]" : "[N]";
        System.out.printf("%s- %-24s %s  $%.2f%n", indent, name, vegLabel, price);
    }
    
}
