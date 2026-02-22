package ProxyPattern.ClientObjects;

import ProxyPattern.RemoteObjects.RemoteGumballMachine;

public class GumballMonitor {
    
    private RemoteGumballMachine gumballMachine;

    public GumballMonitor(RemoteGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void report() {
        try {
            System.out.println("Gumball Machine: " + gumballMachine.getLocation());
            System.out.println("Current inventory: " + gumballMachine.getCount() + " gumballs");
            System.out.println("Current state: " + gumballMachine.getState().getClass().getSimpleName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
