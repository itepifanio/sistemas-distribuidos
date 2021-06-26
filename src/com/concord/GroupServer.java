package com.concord;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class GroupServer {
    GroupServer() {
        try {
            System.setProperty("java.rmi.server.hostname", "192.168.0.5");
            LocateRegistry.createRegistry(1099);
            GroupContract groupContract = new GroupMain();
            Naming.bind("GroupService", (Remote) groupContract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GroupServer();
    }
}
