package com.ttnAssignment.AssignmentRestAPI2.repository;

import com.ttnAssignment.AssignmentRestAPI2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
