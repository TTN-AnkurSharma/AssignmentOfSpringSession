package com.ttnAssignment.AssignmentRestAPI2.controller;

import com.ttnAssignment.AssignmentRestAPI2.entity.User;
import com.ttnAssignment.AssignmentRestAPI2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/versioning")
public class ImplementationQues5Controller {
    @Autowired
    private UserService userService;

    //MIME Versioning
    @GetMapping(value = "/mime", produces = "application/vnd.api.v1+json")
    public Map<String, Object> basicUserMime(@RequestParam long id) {
        User user = userService.getUser(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("age", user.getAge());
        userMap.put("password", user.getPassword());
        return userMap;
    }

    @GetMapping(value = "/mime", produces = "application/vnd.api.v2+json")
    public Map<String, Object> advanceUserMime(@RequestParam long id) {
        User user = userService.getUser(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("age", user.getAge());
        userMap.put("password", user.getPassword());
        userMap.put("address", "Pilkhuwa");
        userMap.put("phone", "952836");
        return userMap;
    }

    //Parameter Versioning
    @GetMapping(value = "/param",params = "version=1")
    public Map<String, Object> basicUserParam(@RequestParam long id) {
        User user = userService.getUser(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("age", user.getAge());
        userMap.put("password", user.getPassword());
        return userMap;
    }

    @GetMapping(value = "/param",params = "version=2")
    public Map<String, Object> advanceUserParam(@RequestParam long id) {

        User user = userService.getUser(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("age", user.getAge());
        userMap.put("password", user.getPassword());
        userMap.put("address", "Pilkhuwa");
        userMap.put("phone", "952836");
        return userMap;
    }

    //URI Versioning
    @GetMapping("/v1")
    public Map<String,Object> basicUserURI(@RequestParam long id)
    {
        User user=userService.getUser(id);
        Map<String,Object> userMap=new HashMap<>();
        userMap.put("id",user.getId());
        userMap.put("name",user.getName());
        userMap.put("age",user.getAge());
        userMap.put("password",user.getPassword());
        return userMap;
    }

    @GetMapping("/v2")
    public Map<String,Object> advanceUserURI(@RequestParam long id)
    {
        User user=userService.getUser(id);
        Map<String,Object> userMap=new HashMap<>();
        userMap.put("id",user.getId());
        userMap.put("name",user.getName());
        userMap.put("age",user.getAge());
        userMap.put("password",user.getPassword());
        userMap.put("address","Pilkhuwa");
        userMap.put("phone","952836");
        return userMap;
    }

    //Header Versioning
    @GetMapping(value = "/param",headers = "API_version=1")
    public Map<String, Object> basicUserHeader(@RequestParam long id) {
        User user = userService.getUser(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("age", user.getAge());
        userMap.put("password", user.getPassword());
        return userMap;
    }

    @GetMapping(value = "/param",headers = "API_version=2")
    public Map<String, Object> getAdvancedUser(@RequestParam long id) {

        User user = userService.getUser(id);
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("id", user.getId());
        userMap.put("name", user.getName());
        userMap.put("age", user.getAge());
        userMap.put("password", user.getPassword());
        userMap.put("address", "Pilkhuwa");
        userMap.put("phone", "952836");
        return userMap;
    }



}
