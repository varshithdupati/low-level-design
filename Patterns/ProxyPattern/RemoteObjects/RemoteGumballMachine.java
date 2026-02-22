package ProxyPattern.RemoteObjects;

import java.rmi.Remote;
import java.rmi.RemoteException;

import ProxyPattern.States.State;

public interface RemoteGumballMachine extends Remote {
    
    int getCount() throws RemoteException;
    String getLocation() throws RemoteException;
    State getState() throws RemoteException;
    
}
