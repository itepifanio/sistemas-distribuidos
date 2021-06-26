package com.concord;

import java.rmi.Naming;
import java.util.Random;

public class GroupClient {
    public static void main(String[] args) {
        try {
            Random random = new Random();

            GroupContract group = (GroupContract) Naming.lookup("rmi://192.168.0.5:1099/GroupService");

            System.out.println("Adding your group to the server");
            group.add(random.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
