package com.concord;

import java.rmi.RemoteException;
import java.util.Scanner;

public class GroupClientService {
    private final Scanner scanner;
    protected GroupContract groupContract;

    public GroupClientService(GroupContract groupContract)
    {
        this.scanner = new Scanner(System.in);

        this.groupContract = groupContract;
    }

    public void execute()
    {
        System.out.println("Welcome to Concord");
        System.out.println("What do you want to do today?");

        String option;

        try {
            label:
            while (true) {
                System.out.println("Press 1 to create one group");
                System.out.println("Press 2 to enter in one group");
                System.out.println("Press 3 to left Concord");

                option = this.scanner.nextLine();

                switch (option) {
                    case "1":
                        this.addToGroup();
                        this.insideGroupOptions();
                        break;
                    case "2":
                        System.out.println("Sorry we didn't implement the enter group yet.");
                        break;
                    case "3":
                        break label;
                    default:
                        System.out.println("This option is invalid.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void insideGroupOptions()
    {
        // display number of clients in the group
        // ability to left group
    }

    private void addToGroup() throws RemoteException {
        System.out.println("Please provide the group name");
        String groupName = this.scanner.nextLine();
        this.groupContract.add(groupName);
    }
}
