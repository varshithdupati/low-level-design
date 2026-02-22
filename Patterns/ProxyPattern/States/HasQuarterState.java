package ProxyPattern.States;

import ProxyPattern.RemoteObjects.GumballMachine;

public class HasQuarterState implements State {

    private static final long serialVersionUID = 1L;
    
    transient GumballMachine gumballMachine;
    
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = (int)(Math.random() * 10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
            gumballMachine.getState().winner();
        } else {
            gumballMachine.setState(gumballMachine.getDispenseState());
            gumballMachine.getState().dispense();
        }
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void winner() {
        // No implementation needed for this state
    }
    
}
