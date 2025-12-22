package StrategyPattern.ducks;

import StrategyPattern.FlyBehavior.*;
import StrategyPattern.QuackBehavior.*;

public class MallardDuck extends Duck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new QuackQuack();
    }
    
    public void display() {
        System.out.println("I look like a Mallard Duck");
    }

}
