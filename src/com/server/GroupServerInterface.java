package com.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GroupServerInterface extends Remote {
    void createGroup(String name) throws RemoteException;
    void enterGroup(int indexGroup) throws RemoteException;
    void publishMessage(String message) throws RemoteException;
    void printMessages() throws RemoteException;
}
