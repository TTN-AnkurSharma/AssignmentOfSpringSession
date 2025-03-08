package com.ttnAssignment.AssignmentRestAPI2.service;

import com.ttnAssignment.AssignmentRestAPI2.entity.User;
import com.ttnAssignment.AssignmentRestAPI2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public User getUser(long id)
    {
        return userRepo.findById(id).get();
    }
    public List<User> getAllUser()
    {
        return userRepo.findAll();
    }
    public User save(User user)
    {
        return userRepo.save(user);
    }
    public String deleteUser(long id)
    {
        User user=getUser(id);
        userRepo.delete(user);
        return "User deleted";
    }
}
