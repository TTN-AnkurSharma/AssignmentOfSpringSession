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
@DiscriminatorValue("E")
public class EmployeeSingle extends PersonSingle{
    private String company;
}
