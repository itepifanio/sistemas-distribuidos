package com.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Group  implements Serializable {
    private final String name;
    private final ArrayList<String> messages;

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
