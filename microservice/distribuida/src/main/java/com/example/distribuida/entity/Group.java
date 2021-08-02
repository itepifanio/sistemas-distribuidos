package com.example.distribuida.entity;

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<Messages> messages;
    private ArrayList<String> users;

    public Group(String name) {
        this.name = name;
        this.messages = new ArrayList<Messages>();
        this.users = new ArrayList<String>();
    }

    public static boolean findGroup(ArrayList<Group> arrayList, String name) {
        for(Group item : arrayList) {
            if(item.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean findUser(String name) {
        for(String item : this.users) {
            if(item.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void setMessage(String user, String message) {
        this.messages.add(new Messages(user, message));
    }

    public boolean setUser(String name) {
        if(!this.findUser(name)) {
            this.users.add(name);
            return true;
        }
        return false;
    }

    public ArrayList<Messages> getMessages() {
        return this.messages;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getUsers() {
        return this.users;
    }
}
