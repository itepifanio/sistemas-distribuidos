package com.objects;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private String message;
    private Date date;
    private final int ownerId;

    public Message(String message, int ownerId) {
        this.message = message;
        this.date = new Date();
        this.ownerId = ownerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getOwnerId()
    {
        return this.ownerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.message + ", " + this.date;
    }
}
