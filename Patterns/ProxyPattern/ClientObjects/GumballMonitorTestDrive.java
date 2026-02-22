package ProxyPattern.ClientObjects;

import ProxyPattern.RemoteObjects.RemoteGumballMachine;

public class GumballMonitorTestDrive {
    
    public static void main(String[] args) {
        String[] locations = {"rmi://localhost/gumballmachine"};
        for (String location : locations) {
            try {
                RemoteGumballMachine gumballMachine = (RemoteGumballMachine) java.rmi.Naming.lookup(location);
                GumballMonitor monitor = new GumballMonitor(gumballMachine);
                monitor.report();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
