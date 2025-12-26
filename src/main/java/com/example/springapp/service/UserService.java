package com.example.springapp.service;

import java.util.List;

import com.example.springapp.model.User;

public interface UserService {
    public User addU(User u);
    public List<User> getAllU();
    public User getUbyId(Long id);
    public User putUbyId(Long id,User u);
    public Boolean deleteUser(Long id);
    public List<User> getUbyRole(String role);
    public List<User> getUbyUserNameandRole(String username,String role);

    
}
