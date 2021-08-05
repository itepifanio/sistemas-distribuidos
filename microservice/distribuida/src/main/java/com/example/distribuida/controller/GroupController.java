package com.example.distribuida.controller;

import com.example.distribuida.entity.Group;
import com.example.distribuida.entity.Messages;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping("grupo")
public class GroupController {
    private ArrayList<Group> groups;
    private ArrayList<String> users;

    @Autowired
    public GroupController() {
        this.groups = new ArrayList<>();
    }

    /*
        Create Group
        name -> Group Name
     */
    @PostMapping(value = "/create", produces = "application/json")
    public Group createGroup(@RequestBody String name) {
        Group group = new Group(name);
        if(!Group.findGroup(this.groups, name)) {
            this.groups.add(group);
        }
        return group;
    }

    /*
        Enter Group
        index -> Id do grupo
        userName -> Nome do usuário
     */
    @PostMapping(value = "/enter/{index}", produces = "application/json")
    public Group enterGroup(@PathVariable("index") int index, @RequestBody String userName) {
        this.groups.get(index).setUser(userName);
        return this.groups.get(index);
    }

    /*
        Publish Message
        index -> Id do grupo
        body -> Json com userName e message
            userName -> Nome do usuário que envia a mensagem
            message -> Texto da mensagem a ser postada
     */
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

    /*
        Get Groups -> Retornar todos os grupos
     */
    @GetMapping(value = "/", produces = "application/json")
    public ArrayList<Group> getGroups() {
        return this.groups;
    }

    /*
        Get Group -> Retorna um grupo em específico
        index -> Id do grupo a ser retornado
     */
    @GetMapping(value = "/{index}", produces = "application/json")
    public Group getGroup(@PathVariable("index") int index) {
        return this.groups.get(index);
    }

    /*
       Get Messages -> Retornar as mensagens de um grupo específico
       index -> Id do grupo a ser retornado as mensagens
    */
    @GetMapping(value = "/{index}/messages", produces = "application/json")
    public ArrayList<Messages> returnMessages(@PathVariable("index") int index) {
        return this.groups.get(index).getMessages();
    }
}