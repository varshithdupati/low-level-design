package StrategyPattern.ducks;

import StrategyPattern.FlyBehavior.*;
import StrategyPattern.QuackBehavior.*;

public class RedheadDuck extends Duck {

    public RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new QuackQuack();
    }
    
    public void display() {
        System.out.println("I look like a Redhead Duck");
    }
    
}
