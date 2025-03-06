package com.ttnAssignment.AssignmentRestAPI.repo;

import com.ttnAssignment.AssignmentRestAPI.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
}
