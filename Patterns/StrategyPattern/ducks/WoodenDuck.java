package StrategyPattern.ducks;

import StrategyPattern.FlyBehavior.*;
import StrategyPattern.QuackBehavior.*;

public class WoodenDuck extends Duck {

    public WoodenDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new QuackNoWay();
    }
    
    public void display() {
        System.out.println("I look like a Wooden Duck");
    }

}
