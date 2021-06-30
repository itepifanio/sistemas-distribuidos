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

    public void createGroup(String name) throws RemoteException {
        this.groups.add(new Group(name));
        System.out.println("Group " + name + " criado!!!");
    }

    public void enterGroup(int indexGroup) throws RemoteException {
        this.indexGroup = indexGroup;
    }

    public void publishMessage(String message) throws RemoteException {
        this.groups.get(this.indexGroup).setMessage(message);
    }

    public ArrayList<String> returnMessages() throws RemoteException {
        return this.groups.get(this.indexGroup).getMessages();
    }
}
