package com.ttnAssignment.JPA3Assignment.repository;

import com.ttnAssignment.JPA3Assignment.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Long> {

}
