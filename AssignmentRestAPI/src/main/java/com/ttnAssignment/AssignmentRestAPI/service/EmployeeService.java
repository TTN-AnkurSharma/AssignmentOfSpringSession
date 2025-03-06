package com.ttnAssignment.AssignmentRestAPI.service;

import com.ttnAssignment.AssignmentRestAPI.entity.Employee;
import com.ttnAssignment.AssignmentRestAPI.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public List<Employee>  getAllEmployee()
    {
        List<Employee> list=employeeRepo.findAll();
        return list;
    }
    public Employee getEmployeeById(long id)
    {
        Employee employee=employeeRepo.findById(id).
                orElseThrow(() -> new RuntimeException("Employee Not Present"));
        return employee;
    }
    public Employee saveEmployee(Employee employee)
    {
        employeeRepo.save(employee);
        return employee;
    }
    public List<Employee> saveAllEmployee(List<Employee> employees)
    {
        employeeRepo.saveAll(employees);
        return employees;
    }
    public Employee deleteEmplopyeeById(long id)
    {
        Employee employee=employeeRepo.findById(id).
                orElseThrow(() -> new RuntimeException("Employee Not Present"));
        return employee;
    }
    public Employee updateEmployee(Employee employee)
    {
        employeeRepo.save(employee);
        return employee;
    }
}
