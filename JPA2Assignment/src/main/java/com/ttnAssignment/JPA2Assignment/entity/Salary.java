package com.ttnAssignment.JPA2Assignment.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Salary {
   private double basicSalary;
   private double bonusSalary;
  private double taxAmount;
  private double specialAllowanceSalary;
}
