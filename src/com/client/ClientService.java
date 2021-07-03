package com.client;

import com.objects.Group;
import com.objects.Message;
import com.server.GroupServerInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ClientService {
    private final GroupServerInterface server;
    private final Scanner scanner;
    private final int ownerId;

    public ClientService(GroupServerInterface server) {
        this.server = server;
        this.scanner = new Scanner(System.in);
        this.ownerId = new Random().nextInt();
    }

    public void execute() throws RemoteException {
        int option;

        label:
        while(true) {
            this.mainMenu();

            option = this.scanner.nextInt();
            this.scanner.nextLine();

            switch (option) {
                case 1:
                    this.addToGroup();
                    this.listGroupOptions();
                    break;
                case 2:
                    this.listGroups();

                    System.out.println("Insert index of group");
                    int groupIndex = this.scanner.nextInt();

                    this.server.enterGroup(groupIndex);
                    this.scanner.nextLine();
                    this.listGroupOptions();

                    break;
                case 0:
                    break label;
                default:
                    System.out.println("This option is invalid.");
                    break;
            }
        }
    }

    private void mainMenu()
    {
        System.out.println("Press 1 to create a group");
        System.out.println("Press 2 to enter in group");
        System.out.println("Press 0 to exit Concord");
    }

    private void groupMenu()
    {
        System.out.println("Press 1 to publish a message");
        System.out.println("Press 2 to print group messages");
        System.out.println("Press 0 to exit the group");
    }

    private void addToGroup() throws RemoteException {
        System.out.println("Insert name of group: ");

        int groupIndex = this.server.createGroup(this.scanner.nextLine());
        this.server.enterGroup(groupIndex);

        System.out.println("Group created with success.");
    }

    private void listGroupOptions() throws RemoteException {
        int option;

        label:
        while(true) {
            this.groupMenu();
            option = this.scanner.nextInt();
            this.scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Insert message:");
                    Message message = new Message(this.scanner.nextLine(), this.ownerId);
                    this.server.publishMessage(message);
                case 2:
                    this.listMessages();
                    break;
                case 0:
                    this.server.enterGroup(-1);
                    break label;
                default:
                    System.out.println("This option is invalid.");
                    break;
            }
        }
    }

    private void listGroups() throws RemoteException {
        ArrayList<Group> groups = this.server.getGroups();

        for(int i = 0; i < groups.size(); i++) {
            System.out.println("Index " + i + " Group " + groups.get(i).getName());
        }
    }

    private void listMessages() throws RemoteException
    {
        ArrayList<Message> messages = this.server.returnMessages();

        for(int i = 0; i < messages.size(); i++) {
            Message message = messages.get(i);

            System.out.println(message.getOwnerId() == this.ownerId ? "You:" : "Anonymous:");
            System.out.println(message);
        }
    }
}
