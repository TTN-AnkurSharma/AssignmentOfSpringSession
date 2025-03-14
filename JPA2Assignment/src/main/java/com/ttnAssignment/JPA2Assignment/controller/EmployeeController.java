package com.ttnAssignment.JPA2Assignment.controller;

import com.ttnAssignment.JPA2Assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/salaryGreater")
    public List<Map<String,Object>> findEmployeeWithSalaryGreaterThanAverage()
    {
        return employeeService.findEmployeeWithSalaryGreaterThanAverage();
    }

    @PutMapping("/updateSalary/{salary}")
    public String updateSalariesBelowAverage(@PathVariable("salary") double salary)
    {
        return employeeService.updateSalariesBelowAverage(salary)+" employees are updated";
    }

    @DeleteMapping("/deleteEmployeeSalary")
    public String deleteEmployeesWithMinimumSalary()
    {
        return employeeService.deleteEmployeesWithMinimumSalary()+" employees deleted";
    }

    @GetMapping("/nameEndingWithSingh")
    public List<Map<String,Object>> findEmployeesByLastNameEndingWithSingh()
    {
        return employeeService.findEmployeesByLastNameEndingWithSingh();
    }

    @DeleteMapping("/deleteEmployeeAge/{age}")
    public String deleteEmployeesOlderThan(@PathVariable("age") int age)
    {
        return employeeService.deleteEmployeesOlderThan(age)+" employees deleted";
    }


}
