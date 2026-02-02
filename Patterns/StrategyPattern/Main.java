package StrategyPattern;

import java.util.*;
import java.util.function.*;

import StrategyPattern.FlyBehavior.FlyWithRocket;
import StrategyPattern.ducks.*;

public class Main {

    public static void main(String[] args) {
    
        List<Supplier<? extends Duck>> ducks = List.of(
            () -> new MallardDuck(),
            () -> new RedheadDuck(),
            () -> new RubberDuck(),
            () -> new WoodenDuck()
        );

        for(Supplier<? extends Duck> duckSignature: ducks) {
            Duck duck = duckSignature.get();
            run(duck);
        }

        Duck duck = new RubberDuck();
        duck.setFlyBehavior(new FlyWithRocket());
        run(duck);

    }

    private static void run(Duck duck) {
        duck.display();
        duck.fly();
        duck.swim();
        duck.quack();
    }

}
