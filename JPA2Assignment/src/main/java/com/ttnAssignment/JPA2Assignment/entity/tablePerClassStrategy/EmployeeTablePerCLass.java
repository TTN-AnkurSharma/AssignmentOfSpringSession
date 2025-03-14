package com.ttnAssignment.JPA2Assignment.entity.tablePerClassStrategy;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeTablePerCLass extends PersonTablePerClass {
    private String company;
}
