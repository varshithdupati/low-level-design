package StrategyPattern.ducks;

import StrategyPattern.FlyBehavior.*;
import StrategyPattern.QuackBehavior.*;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new QuackSqueak();
    }
    
    public void display() {
        System.out.println("I look like a Rubber Duck");
    }

}
