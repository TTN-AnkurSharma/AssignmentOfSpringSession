package com.ttnAssignment.JPA2Assignment.entity.sinlgeTableStartegy;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("T")
public class TeacherSingle extends PersonSingle{
    private String college;
}
