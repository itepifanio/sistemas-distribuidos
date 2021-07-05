package com.server;

import com.objects.Group;
import com.objects.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GroupServer extends UnicastRemoteObject implements GroupServerInterface {
    private final ArrayList<Group> groups;
    private int indexGroup;

    public GroupServer() throws RemoteException {
        super();
        this.groups = new ArrayList<Group>();
        this.indexGroup = -1;
    }

    public int createGroup(String name) throws RemoteException {
        this.groups.add(new Group(name));

        return groups.size()-1;
    }

    public void enterGroup(int indexGroup) throws RemoteException {
        this.indexGroup = indexGroup;
    }

    public void publishMessage(Message message) throws RemoteException {
        this.groups.get(this.indexGroup).setMessage(message);
    }

    public ArrayList<Group> getGroups() throws RemoteException {
        return this.groups;
    }

    public ArrayList<Message> returnMessages() throws RemoteException {
        return this.groups.get(this.indexGroup).getMessages();
    }
}
