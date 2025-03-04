package com.ttnAssignment.Assignment2SpringBoot.service;

import com.ttnAssignment.Assignment2SpringBoot.entity.Employee;
import com.ttnAssignment.Assignment2SpringBoot.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public void saveAll(List<Employee> list)
    {
        employeeRepo.saveAll(list);
    }
}
