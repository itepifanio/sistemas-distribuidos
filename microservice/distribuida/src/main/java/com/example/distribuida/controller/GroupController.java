package com.example.distribuida.controller;

import com.example.distribuida.entity.Group;
import com.example.distribuida.entity.Messages;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping(value = "/create", produces = "application/json")
    public Group createGroup(@RequestBody String name) {
        Group group = new Group(name);
        if(!Group.findGroup(this.groups, name)) {
            this.groups.add(group);
        }
        return group;
    }

    @PostMapping(value = "/enter/{index}", produces = "application/json")
    public Group enterGroup(@PathVariable("index") int index, @RequestBody String userName) {
        this.groups.get(index).setUser(userName);
        return this.groups.get(index);
    }

    @PostMapping(value = "/publish/{index}", produces = "application/json")
    public ArrayList<Messages> publishMessage(
            @PathVariable("index") int index,
            @RequestBody String body
    ) throws JSONException {

        JSONObject json = new JSONObject(body);
        this.groups.get(index).setMessage(
                json.get("userName").toString(),
                json.get("message").toString()
        );
        return this.groups.get(index).getMessages();
    }

    @GetMapping(value = "/", produces = "application/json")
    public ArrayList<Group> getGroups() {
        return this.groups;
    }

    @GetMapping(value = "/{index}", produces = "application/json")
    public Group getGroup(@PathVariable("index") int index) {
        return this.groups.get(index);
    }

    @GetMapping(value = "/{index}/messages", produces = "application/json")
    public ArrayList<Messages> returnMessages(@PathVariable("index") int index) {
        return this.groups.get(index).getMessages();
    }
}
