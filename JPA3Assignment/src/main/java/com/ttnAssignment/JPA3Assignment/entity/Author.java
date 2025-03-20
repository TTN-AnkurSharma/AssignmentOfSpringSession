package com.ttnAssignment.JPA3Assignment.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "author_table")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private long authorId;
    private String authorName;

    @Embedded
    private Address address;

    @ElementCollection
    private List<String> subjects;

    @OneToOne(mappedBy = "author",cascade = CascadeType.ALL)
    private BookOneTOOne bookOneTOOne;

    @OneToMany
    @JoinColumn(name ="authorId")
    private List<BookOneToManyUnidirectional> bookOneToManyUnidirectionals;

    @OneToMany(mappedBy = "author",cascade = CascadeType.PERSIST)
    private List<BookOneToMany> bookOneToManyList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "author_book",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookManyToMany> bookManyToManyList;



}
