package StrategyPattern.QuackBehavior;

public class QuackNoWay implements QuackBehavior {

    public void quack() {
        System.out.println("<< Silence >>");
    }
    
}
