package com.ttnAssignment.JPA3Assignment.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class BookOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
