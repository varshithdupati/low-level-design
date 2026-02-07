package FactoryPattern.Pizzas;

public abstract class Pizza {

    String name;
    
    public void prepare() {
        System.out.println("Preparing " + name + " pizza ...");
    }

    public void bake() {
        System.out.println("Baking " + name + " pizza ...");
    }

    public void cut() {
        System.out.println("Cutting " + name + " pizza ...");
    }

    public void box() {
        System.out.println("Boxing " + name + " pizza ...");
    }

}
