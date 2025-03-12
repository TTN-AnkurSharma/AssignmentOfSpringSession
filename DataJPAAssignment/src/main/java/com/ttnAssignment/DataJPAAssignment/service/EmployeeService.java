package com.ttnAssignment.DataJPAAssignment.service;


import com.ttnAssignment.DataJPAAssignment.entity.Employee;
import com.ttnAssignment.DataJPAAssignment.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public String saveEmployee(Employee employee)
    {
        employeeRepo.save(employee);
        return "Employee data inserted";
    }

    public String updateEmployee(Employee employee)
    {
        employeeRepo.save(employee);
        return "Employee data updated";
    }

    public Employee delelteEmployee(long id)
    {
        Employee toDelete =getEmployee(id);
       employeeRepo.delete(toDelete);

       return toDelete;

    }

    public Employee getEmployee(long id)
    {
        return employeeRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Employee with ID " + id + " not found")
        );
    }

    public long countEmployee()
    {
        return employeeRepo.count();
    }

    public List<Employee> paginationDemo(int page,int size)
    {
      List<Employee> fetched=employeeRepo
              .findAll(PageRequest.of(page,
                      size
                      , Direction.ASC
                      ,new String[]{"age"}))
              .getContent();
      return fetched;
    }

    public List<Employee> findByName(String name)
    {
        List<Employee> employeesWithGivenName=employeeRepo.findAllByName(name);
        return employeesWithGivenName;
    }

    public List<Employee> findStartsWithPrefix(char ch)
    {
        List<Employee> employeesStartWithGivenPrefix=employeeRepo.findByNameStartingWith(ch);
        return employeesStartWithGivenPrefix;
    }

    public List<Employee> employeesInRange(int start,int end)
    {
        List<Employee> employeesInBetweenAge=employeeRepo.findByAgeBetween(start,end);
        return employeesInBetweenAge;
    }


    //util function to add list of employees
    public void saveAll(List<Employee> employees)
    {
        employeeRepo.saveAll(employees);
    }
}
