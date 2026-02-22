package ProxyPattern.RemoteObjects;

import java.rmi.Naming;

public class RegisterRemoteGumballMachine {
    
    public static void main(String[] args) {
        try {
            if (args.length<2) {
                System.out.println("Usage: java RegisterRemoteGumballMachine <location> <inventory>");
                System.exit(1);
            }
            GumballMachine gumballMachine = new GumballMachine(args[0], Integer.parseInt(args[1]));
            Naming.rebind("//" + args[0] + "/gumballmachine", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
