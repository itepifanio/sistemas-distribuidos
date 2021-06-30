package com.objects;

import java.util.ArrayList;

public class Group {
    private String name;
    private ArrayList<String> messages;

    public Group(String name) {
        this.name = name;
        this.messages = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setMessage(String message) {
        this.messages.add(message);
    }

    public ArrayList<String> getMessages() {
        return this.messages;
    }

    public void printMessages() {
        System.out.println(this.messages);
    }
}
