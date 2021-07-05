package com.server;

import com.objects.Group;
import com.objects.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GroupServerInterface extends Remote {
    int createGroup(String name) throws RemoteException;
    void enterGroup(int indexGroup) throws RemoteException;
    void publishMessage(Message message) throws RemoteException;
    ArrayList<Group> getGroups() throws RemoteException;
    ArrayList<Message> returnMessages() throws RemoteException;
}
