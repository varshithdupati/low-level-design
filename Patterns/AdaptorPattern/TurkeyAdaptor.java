package AdaptorPattern;

import AdaptorPattern.Duck.Duck;
import AdaptorPattern.Turkey.Turkey;

public class TurkeyAdaptor implements Duck {

    Turkey turkey;

    public TurkeyAdaptor(Turkey turkey) {
        this.turkey = turkey;
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        for(int i=1; i<=5; i++) {
            turkey.shortFly();
        }
    }
    
}
