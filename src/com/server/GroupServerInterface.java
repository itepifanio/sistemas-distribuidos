package com.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GroupServerInterface extends Remote {
    void createGroup(String name) throws RemoteException;
    void enterGroup(int indexGroup) throws RemoteException;
    void publishMessage(String message) throws RemoteException;
    ArrayList<String> returnMessages() throws RemoteException;
}
