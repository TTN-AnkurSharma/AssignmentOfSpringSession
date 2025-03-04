package com.ttnAssignment.Assignment2SpringBoot;

import com.ttnAssignment.Assignment2SpringBoot.config.Appconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImplementationOfQues_2 {
    @Autowired
    private Appconfig appconfig;
    public void showProperties()
    {
        System.out.println("Name is "+appconfig.getName());
        System.out.println("Age is "+appconfig.getAge());
    }
}
