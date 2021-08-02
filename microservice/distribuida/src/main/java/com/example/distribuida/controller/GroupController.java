package com.example.distribuida.controller;

import com.example.distribuida.entity.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("grupo")
public class GroupController {
    private ArrayList<Group> groups;
    private int indexGroup;

    @Autowired
    public GroupController() {
        this.groups = new ArrayList<>();
        this.indexGroup = -1;
    }

    @PostMapping(value = "/create/{name}", produces = "application/json")
    public ArrayList<Group> createGroup(@PathVariable("name") String name) {
        this.groups.add(new Group(name));
        return this.groups;
    }

    @PostMapping(value = "/enter/{index}", produces = "application/json")
    public Group enterGroup(@PathVariable("index") int index) {
        this.indexGroup = index;
        return this.groups.get(index);
//        return "Você agora está no grupo " + this.groups.get(this.indexGroup).getName() + "!";
    }

    @PostMapping(value = "/publish/{message}", produces = "application/json")
    public ArrayList<String> publishMessage(@PathVariable("message") String message) {
        this.groups.get(this.indexGroup).setMessage(message);
        return this.groups.get(this.indexGroup).getMessages();
    }

    @GetMapping(value = "/messages", produces = "application/json")
    public ArrayList<String> returnMessages() {
        return this.groups.get(this.indexGroup).getMessages();
    }
}
