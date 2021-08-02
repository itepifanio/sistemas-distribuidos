package com.example.distribuida.controller;

import com.example.distribuida.entity.Group;
import com.example.distribuida.entity.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("grupo")
public class GroupController {
    private ArrayList<Group> groups;
    private ArrayList<String> users;
    private int indexGroup;

    @Autowired
    public GroupController() {
        this.groups = new ArrayList<>();
    }

    @PostMapping(value = "/create/{name}", produces = "application/json")
    public ArrayList<Group> createGroup(@PathVariable("name") String name) {
        if(!Group.findGroup(this.groups, name)) {
            this.groups.add(new Group(name));
        }
        return this.groups;
    }

    @GetMapping(value = "/{index}", produces = "application/json")
    public Group createGroup(@PathVariable("index") int index) {
        return this.groups.get(index);
    }


    @PostMapping(value = "/enter/{index}/{userName}", produces = "application/json")
    public Group enterGroup(@PathVariable("index") int index, @PathVariable("userName") String userName) {
        this.groups.get(index).setUser(userName);
        return this.groups.get(index);
    }

    @PostMapping(value = "/publish/{index}/{userName}/{message}", produces = "application/json")
    public ArrayList<Messages> publishMessage(
            @PathVariable("index") int index,
            @PathVariable("userName") String userName,
            @PathVariable("message") String message
    ) {
        this.groups.get(index).setMessage(userName, message);
        return this.groups.get(index).getMessages();
    }

    @GetMapping(value = "/{index}/messages", produces = "application/json")
    public ArrayList<Messages> returnMessages(@PathVariable("index") int index) {
        return this.groups.get(index).getMessages();
    }
}
