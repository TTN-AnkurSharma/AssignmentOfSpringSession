package com.ttnAssignment.Assignment2SpringBoot.controller;

import com.ttnAssignment.Assignment2SpringBoot.entity.Employee;
import com.ttnAssignment.Assignment2SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/save")
    public void save()
    {

        Employee emp1 = new Employee("Ankur Sharma","JVM Trainee");

        Employee emp2 = new Employee("Alok Kumar Maurya","JS Trainee");

        Employee emp3 = new Employee("Aryan Chaudhary","QA Analyst");

        List<Employee> list=List.of(emp1,emp2,emp3);
     //   list.stream().forEach(employee -> System.out.println(employee.getName()));
        employeeService.saveAll(list);


    }
}
