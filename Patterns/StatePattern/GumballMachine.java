package StatePattern;

import StatePattern.States.NoQuarterState;
import StatePattern.States.HasQuarterState;
import StatePattern.States.SoldOutState;
import StatePattern.States.DispenseState;
import StatePattern.States.WinnerState;
import StatePattern.States.State;

public class GumballMachine {

    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldOutState;
    private final State dispenseState;
    private final State winnerState;
    
    private int count;
    private State state;
    
    public GumballMachine(int count) {
        this.count = count;
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldOutState = new SoldOutState(this);
        dispenseState = new DispenseState(this);
        winnerState = new WinnerState(this);
        state = soldOutState;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    public void refill(int count) {
        this.count += count;
        System.out.println("The gumball machine was just refilled; it's new count is: " + this.count);
        state = noQuarterState;
    }

    public int getCount() {
        return count;
    }

    public void releaseBall() {
        if (count > 0) {
            System.out.println("A gumball comes rolling out the slot...");
            count--;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public State getWinnerState() {
        return winnerState;
    }

}
