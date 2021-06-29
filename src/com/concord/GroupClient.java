package com.concord;

import java.rmi.Naming;
import java.util.Random;
import java.util.Scanner;

public class GroupClient {
    public static void main(String[] args) {
        try {
            GroupContract group = (GroupContract) Naming.lookup("rmi://127.0.0.1:1099/GroupService");

            GroupClientService service = new GroupClientService(group);

            service.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
