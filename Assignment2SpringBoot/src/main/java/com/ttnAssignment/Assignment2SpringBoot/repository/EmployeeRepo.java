package com.ttnAssignment.Assignment2SpringBoot.repository;

import com.ttnAssignment.Assignment2SpringBoot.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
