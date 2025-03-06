package com.ttnAssignment.AssignmentRestAPI.controller;


import com.ttnAssignment.AssignmentRestAPI.entity.Employee;
import com.ttnAssignment.AssignmentRestAPI.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //To get All the employees present
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployee()
    {
        List<Employee> list=employeeService.getAllEmployee();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //To get employee by id
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Employee employee=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    //Save an employee to db
    @PostMapping("/")
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    //Save multiple employee to db
    @PostMapping("/all")
    public ResponseEntity<List<Employee>>saveAllEmployee(@Valid @RequestBody List<Employee> employees)
    {
        employeeService.saveAllEmployee(employees);
        return new ResponseEntity<>(employees,HttpStatus.CREATED);
    }

    //delete employee of given id
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id)
    {
       Employee deletedEmployee= employeeService.deleteEmplopyeeById(id);
        return new ResponseEntity<>(deletedEmployee,HttpStatus.OK);
    }

    //update the details of employee in db
    @PutMapping("/id")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
