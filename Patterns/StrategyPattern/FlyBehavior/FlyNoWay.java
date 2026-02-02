package StrategyPattern.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

    public void fly() {
        System.out.println("<< Can't fly >>");
    }
    
}
