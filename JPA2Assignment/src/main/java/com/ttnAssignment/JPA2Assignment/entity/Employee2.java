package com.ttnAssignment.JPA2Assignment.entity;

import jakarta.persistence.*;
import lombok.*;
/*For ques 4 created
Employee2 as Employee entity is already present*/

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "employeeTable2")
public class Employee2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empId")
    private int Id;

    @Column(name = "empFirstName")
    private String firstName;

    @Column(name = "empLastName")
    private String lastName;

    @Column(name = "empAge")
    private int age;

    @Embedded
    private Salary salary;
}
