package com.ttnAssignment.JPA2Assignment.entity.joinedStrategy;


import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TeacherJoined extends PersonJoined{
    private String college;
}
