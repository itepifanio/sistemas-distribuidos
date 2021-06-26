package com.concord;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Queue;

public class GroupMain extends UnicastRemoteObject implements GroupContract {
    private LinkedList<String> clientGroups;

    protected GroupMain() throws RemoteException {
        super();

        this.clientGroups = new LinkedList<String>();
    }

    @Override
    public void add(String client) throws RemoteException {
        if(clientGroups.size() > 2) {
            throw new RemoteException("Max group reached");
        }

        clientGroups.add(client);
    }
}
