package com.client;

import com.server.GroupServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        GroupServerInterface server = (GroupServerInterface)
                Naming.lookup("rmi://127.0.0.1:1099/GroupServer");

        ClientService clientService = new ClientService(server);

        try {
            clientService.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
