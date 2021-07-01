package com.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException {

        System.setProperty("java.rmi.server.hostname","127.0.0.1");

        GroupServerInterface server = new GroupServer();

        LocateRegistry.createRegistry(1099);

        Naming.rebind("rmi://127.0.0.1:1099/GroupServer", server);

        System.out.println("Server Starterd.");
    }
}
