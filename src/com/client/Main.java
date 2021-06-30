package com.client;

import com.server.GroupServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        GroupServerInterface server = (GroupServerInterface)
                Naming.lookup("rmi://127.0.0.1:1099/GroupServer");

        Scanner scanner = new Scanner(System.in);
        int option;

        /*
        O que pode melhorar?
            1 - Nas messages ter a informação de quem publicou (User)
            2 - Print groups com os index
            3 - Lançar exceções ao inserir index errado
         */
        label:
        while(true) {
            System.out.println("Press 1 to create one group");
            System.out.println("Press 2 to enter or exit in one group");
            System.out.println("Press 3 to publish a message");
            System.out.println("Press 4 to print group messages");
            System.out.println("Press 0 to exit Concord");

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Insert name of group: ");
                    server.createGroup(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Insert index of group or insert -1 to exit: ");
                    server.enterGroup(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Insert message:");
                    server.publishMessage(scanner.nextLine());
                    break;
                case 4:
                    System.out.println(server.returnMessages());
                    break;
                case 0:
                    break label;
                default:
                    System.out.println("This option is invalid.");
                    break;
            }
        }
    }
}
