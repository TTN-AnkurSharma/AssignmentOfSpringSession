package com.ttnAssignment.JPA3Assignment.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {
    private int streetNumber;
    private String location;
    private String state;
}
