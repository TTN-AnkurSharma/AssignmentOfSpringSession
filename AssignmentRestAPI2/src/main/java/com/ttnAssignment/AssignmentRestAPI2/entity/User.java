package com.ttnAssignment.AssignmentRestAPI2.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import jakarta.persistence.*;


@JsonFilter("UserEnhancedFilter")
@Entity
@Table(name = "userTable")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Long id;

    @Column(name = "username")
    private String name;

    @Column(name = "age")
    private int age;

  //  @JsonIgnore for static filetering

    @Column(name = "password")
    private String password;



    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }
}
