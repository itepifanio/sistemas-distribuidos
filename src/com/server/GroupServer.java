package com.server;

import com.objects.Group;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GroupServer extends UnicastRemoteObject implements GroupServerInterface {
    private ArrayList<Group> groups;
    private int indexGroup;

    public GroupServer() throws RemoteException {
        super();
        this.groups = new ArrayList<>();
        this.indexGroup = -1;
    }

    @Override
    public void createGroup(String name) throws RemoteException {
        this.groups.add(new Group(name));
        System.out.println("Group " + name + " criado!!!");
    }

    @Override
    public void enterGroup(int indexGroup) throws RemoteException {
        this.indexGroup = indexGroup;
    }

    @Override
    public void publishMessage(String message) throws RemoteException {
        this.groups.get(this.indexGroup).setMessage(message);
    }

    @Override
    public void printMessages() throws RemoteException {
        this.groups.get(this.indexGroup).printMessages();
    }
}
