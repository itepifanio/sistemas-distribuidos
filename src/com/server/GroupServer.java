package com.server;

import com.objects.Group;
import com.objects.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class GroupServer extends UnicastRemoteObject implements GroupServerInterface {
    private final ArrayList<Group> groups;
    private int groupIndex;

    public GroupServer() throws RemoteException {
        super();
        this.groups = new ArrayList<Group>();
        this.groupIndex = -1;
    }

    public int createGroup(String name) throws RemoteException {
        this.groups.add(new Group(name));

        return groups.size()-1;
    }

    public boolean validIndex(int groupIndex) throws RemoteException {
        try {
            this.groups.get(groupIndex);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    public void publishMessage(Message message, int groupIndex) throws RemoteException {
        this.groups.get(groupIndex).setMessage(message);
    }

    public ArrayList<Group> getGroups() throws RemoteException {
        return this.groups;
    }

    public ArrayList<Message> returnMessages(int groupIndex) throws RemoteException {
        return this.groups.get(groupIndex).getMessages();
    }
}
