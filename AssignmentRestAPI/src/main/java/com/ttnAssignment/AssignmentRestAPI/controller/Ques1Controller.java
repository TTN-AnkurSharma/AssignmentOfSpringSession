package com.ttnAssignment.AssignmentRestAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class Ques1Controller {

    @GetMapping("/")
    public String greetMessage()
    {
        return "Welcome to spring boot";
    }
}
