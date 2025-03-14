package com.ttnAssignment.JPA2Assignment.entity.tablePerClassStrategy;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeacherTablePerClass extends PersonTablePerClass {
    private String college;
}
