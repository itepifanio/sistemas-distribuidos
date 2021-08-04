package br.rest.server.entity;

public class Messages {
    private String user;
    private String message;

    public Messages(String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getUser() {
        return user;
    }
}
