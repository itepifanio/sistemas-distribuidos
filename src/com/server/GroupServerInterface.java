package com.server;

import com.objects.Group;
import com.objects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GroupServerInterface extends Remote {
    int createGroup(String name) throws RemoteException;
    boolean validIndex(int groupIndex) throws RemoteException;
    void publishMessage(Message message, int groupIndex) throws RemoteException;
    ArrayList<Group> getGroups() throws RemoteException;
    ArrayList<Message> returnMessages(int groupIndex) throws RemoteException;
}
