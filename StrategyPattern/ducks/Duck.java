package StrategyPattern.ducks;

import StrategyPattern.FlyBehavior.FlyBehavior;
import StrategyPattern.QuackBehavior.QuackBehavior;

public abstract class Duck {

    public FlyBehavior flyBehavior;
    public QuackBehavior quackBehavior;
    
    public abstract void display();

    public void swim() {
        System.out.println("I swim");
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
}
