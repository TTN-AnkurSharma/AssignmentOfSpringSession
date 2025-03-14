package com.ttnAssignment.JPA2Assignment.repository;

import com.ttnAssignment.JPA2Assignment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    @Query("SELECT e.firstName, e.lastName FROM Employee e " +
            "WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2) " +
            "ORDER BY e.age ASC, e.salary DESC")
    List<Object[]> findEmployeeWithSalaryGreaterThanAverage();

    @Modifying
    @Query("UPDATE Employee e " +
            "SET e.salary = :newSalary " +
            "WHERE e.salary < (SELECT AVG(e2.salary) FROM Employee e2)")
    int updateSalariesBelowAverage(@Param("newSalary") double newSalary);

    @Modifying
    @Query("DELETE FROM Employee e " +
            "WHERE e.salary = (SELECT MIN(e2.salary) FROM Employee e2)")
    int deleteEmployeesWithMinimumSalary();

    @Query(value = "SELECT empId,empFirstName,empAge FROM employeeTable WHERE empLastName LIKE %singh",nativeQuery = true)
    List<Object[]> findEmployeesByLastNameEndingWithSingh();

    @Modifying
    @Query(value = "DELETE FROM employeeTable WHERE empAge > :age", nativeQuery = true)
    int deleteEmployeesOlderThan(@Param("age") int age);


}
