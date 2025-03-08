package com.ttnAssignment.AssignmentRestAPI2.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.ttnAssignment.AssignmentRestAPI2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/filter")
public class ImplementationQues4Controller {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public MappingJacksonValue getAllUser() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userService.getAllUser());// here given user list
        PropertyFilter filter = SimpleBeanPropertyFilter.serializeAllExcept("password");
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(true);
        simpleFilterProvider.addFilter("UserEnhancedFilter",filter);
        mappingJacksonValue.setFilters(simpleFilterProvider);

        return mappingJacksonValue;
    }


}
