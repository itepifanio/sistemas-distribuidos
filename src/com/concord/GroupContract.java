package com.concord;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GroupContract extends Remote {
    public void add(String client) throws RemoteException;
}
