package com.ttnAssignment.JPA2Assignment.service;

import com.ttnAssignment.JPA2Assignment.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    public  List<Map<String,Object>> findEmployeeWithSalaryGreaterThanAverage()
    {
       List<Map<String,Object>> empDetails=new ArrayList<>();
        for(Object[] details:employeeRepo.findEmployeeWithSalaryGreaterThanAverage())
        {
            HashMap<String,Object> map=new HashMap<>();
            map.put("firstName",details[0]);
            map.put("lastName",details[1]);
           empDetails.add(map);
        }
        return empDetails;
    }

    public int updateSalariesBelowAverage(double salary)
    {
        return employeeRepo.updateSalariesBelowAverage(salary);
    }

    public int deleteEmployeesWithMinimumSalary()
    {
        return employeeRepo.deleteEmployeesWithMinimumSalary();
    }


    public List<Map<String,Object>> findEmployeesByLastNameEndingWithSingh()
    {
        List<Map<String,Object>> empDetails=new ArrayList<>();
        for(Object[] details:employeeRepo.findEmployeeWithSalaryGreaterThanAverage())
        {
            HashMap<String,Object> map=new HashMap<>();
            map.put("empId",details[0]);
            map.put("empFirstName",details[1]);
            map.put("empAge",details[2]);
            empDetails.add(map);
        }
        return empDetails;
    }

    public int deleteEmployeesOlderThan(int age)
    {
        return employeeRepo.deleteEmployeesOlderThan(age);
    }
}
