package TemplateMethodPattern;

public abstract class CaffineBeverage {
    
    // template method
    final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // fixed methods

    final void boilWater() {
        System.out.println("Boiling water ...");
    }

    final void pourInCup() {
        System.out.println("Pour beverage in cup ..");
    }

    // subclasses must override implementation

    abstract void brew();

    // subclasses can optionally override implementation
    
    void addCondiments() {}

}
