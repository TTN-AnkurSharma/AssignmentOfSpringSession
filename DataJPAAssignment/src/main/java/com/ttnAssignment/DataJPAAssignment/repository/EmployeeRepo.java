package com.ttnAssignment.DataJPAAssignment.repository;

import com.ttnAssignment.DataJPAAssignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    List<Employee> findAllByName(String name);
    List<Employee> findByNameStartingWith(char prefix);
    List<Employee> findByAgeBetween(int start, int end);

}
