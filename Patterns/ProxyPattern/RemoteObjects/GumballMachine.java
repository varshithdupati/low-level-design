package ProxyPattern.RemoteObjects;

import ProxyPattern.States.NoQuarterState;
import ProxyPattern.States.HasQuarterState;
import ProxyPattern.States.SoldOutState;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import ProxyPattern.States.DispenseState;
import ProxyPattern.States.WinnerState;
import ProxyPattern.States.State;

public class GumballMachine extends UnicastRemoteObject implements RemoteGumballMachine {

    private static final long serialVersionUID = 1L;

    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldOutState;
    private final State dispenseState;
    private final State winnerState;
    
    private int count;
    private State state;

    private String location;
    
    public GumballMachine(String location, int count) throws RemoteException {
        this.location = location;
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

    public String getLocation() {
        return location;
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
