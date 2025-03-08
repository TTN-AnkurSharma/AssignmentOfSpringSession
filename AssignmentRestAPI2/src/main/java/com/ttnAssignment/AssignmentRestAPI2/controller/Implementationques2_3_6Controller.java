package com.ttnAssignment.AssignmentRestAPI2.controller;

/* Create POST Method to create user details which can accept XML for user creation.
Create GET Method to fetch the list of users in XML format.*/

import com.ttnAssignment.AssignmentRestAPI2.entity.User;
import com.ttnAssignment.AssignmentRestAPI2.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/content")
public class Implementationques2_3_6Controller {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/",produces = "application/xml")
    @Operation(summary = "Get all users", description = "Retrieves a list of all users in XML format.")
    public List<User> getUsers()
    {
        return userService.getAllUser();
    }

    @PostMapping(value = "/",consumes = "application/xml")
    @Operation(summary = "Add a new user", description = "Accepts a User object in XML format and saves it to the database.")
    public EntityModel<User> saveUser(@RequestBody User user)
    {
        userService.save(user);
        EntityModel entityModel= EntityModel.of(user);
        WebMvcLinkBuilder webMvcLinkBuilder=linkTo( WebMvcLinkBuilder.methodOn(this.getClass()).getUsers());
        entityModel.add(webMvcLinkBuilder.withRel("all-users"));
        return entityModel;

    }

    @DeleteMapping("/")
    @Operation(summary = "Delete user",description = "Accepts id and delete particular user.")
    public String deleteUser(@RequestParam long id)
    {
        return userService.deleteUser(id);
    }

}
