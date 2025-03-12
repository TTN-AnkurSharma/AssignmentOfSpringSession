package com.ttnAssignment.DataJPAAssignment.controller;

import com.ttnAssignment.DataJPAAssignment.entity.Employee;
import com.ttnAssignment.DataJPAAssignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public String updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.delelteEmployee(id);
        return "Employee with ID " + id + " has been deleted.";
    }

    @GetMapping("/employees")
    public Employee getEmployeeById(@RequestParam long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees/count")
    public long countTotalEmployee() {
        return employeeService.countEmployee();
    }

    @GetMapping("/employees/pagination")
    public List<Employee> paginationDemo(@RequestParam int page, @RequestParam int size) {
        return employeeService.paginationDemo(page, size);
    }

    @GetMapping("/employees/find-by-name")
    public List<Employee> findByName(@RequestParam String name) {
        return employeeService.findByName(name);
    }

    @GetMapping("/employees/find-by-prefix")
    public List<Employee> findStartsWithPrefix(@RequestParam char prefix) {
        return employeeService.findStartsWithPrefix(prefix);
    }

    @GetMapping("/employees/range")
    public List<Employee> employeesInRange(@RequestParam int start, @RequestParam int end) {
        return employeeService.employeesInRange(start, end);
    }

    @PostMapping("/employees/all")
    public String saveAll(@RequestBody List<Employee> employees) {
        employeeService.saveAll(employees);
        return "All employees have been saved.";
    }
}
