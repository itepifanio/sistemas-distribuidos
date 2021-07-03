package com.objects;

import java.io.Serializable;
import java.util.ArrayList;

public class Group  implements Serializable {
    private final String name;
    private final ArrayList<Message> messages;

    public Group(String name) {
        this.name = name;
        this.messages = new ArrayList<Message>();
    }

    public String getName() {
        return name;
    }

    public void setMessage(Message message) {
        this.messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return this.messages;
    }

    public void printMessages() {
        System.out.println(this.messages);
    }
}
