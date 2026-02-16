package AdaptorPattern;

import AdaptorPattern.Duck.MallardDuck;
import AdaptorPattern.Turkey.OsceolaTurkey;
import AdaptorPattern.Turkey.Turkey;
import AdaptorPattern.Duck.Duck;

public class AdaptorDemo {
    
    public static void main(String[] args) {
        
        Duck duck1 = new MallardDuck();

        Turkey turkey = new OsceolaTurkey();
        Duck duck2 = new TurkeyAdaptor(turkey);

        test(duck1);
        test(duck2);

    }

    private static void test(Duck duck) {
        duck.quack();
        duck.fly();
    }

}
