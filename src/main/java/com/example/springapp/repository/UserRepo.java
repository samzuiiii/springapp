package com.example.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springapp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
       public List<User> findByRole(String role);
       public List<User> findByUsernameAndRole(String username,String role);
    
}
