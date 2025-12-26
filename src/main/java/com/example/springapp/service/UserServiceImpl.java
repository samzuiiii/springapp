package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.springapp.model.User;
import com.example.springapp.repository.UserRepo;


@Service
public class UserServiceImpl implements UserService{
      @Autowired
      private UserRepo urepo;
      
      @Override
      public User addU(User u){
        return urepo.save(u);
      }
      @Override
      public List<User> getAllU(){
        return urepo.findAll();
      }
      @Override
      public User getUbyId(Long id){
        return urepo.findById(id).orElse(null);
     }
     @Override
     public User putUbyId(Long id,User u){
        User exists=urepo.findById(id).orElse(null);
        if(exists==null){
            return null;
        }
        exists.setUsername(u.getUsername());
        exists.setEmail(u.getEmail());
        exists.setRole(u.getRole());
        return urepo.save(exists);
    }
    @Override
    public Boolean deleteUser(Long id){
        User del=urepo.findById(id).orElse(null);
        if(del==null){
            return false;
        }
        urepo.deleteById(id);
        return true;
    }
    @Override
    public List<User> getUbyRole(String role){
      return urepo.findByRole(role);
      
    }
    @Override
    public List<User> getUbyUserNameandRole(String username,String role){
      return urepo.findByUsernameAndRole(username, role);
    }
    
}
