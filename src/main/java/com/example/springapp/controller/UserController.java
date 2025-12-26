package com.example.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.springapp.model.User;
import com.example.springapp.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
         @Autowired
         private UserService uSer;

         @PostMapping
         public ResponseEntity<User> addU(@RequestBody User u){
            User saved=uSer.addU(u);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);
        }
        @GetMapping
        public ResponseEntity<List<User>> getAllU(){
            List<User> saved=uSer.getAllU();
            return new ResponseEntity<>(saved,HttpStatus.OK);
        }
        @GetMapping("/{id}")
        public ResponseEntity<User> getUbyId(@PathVariable Long id){
            User uid=uSer.getUbyId(id);
            return new ResponseEntity<>(uid,HttpStatus.OK);
        }
        @PutMapping("/{id}")
        public ResponseEntity<User> putUbyId(@PathVariable Long id,@RequestBody User u){
           User uid=uSer.putUbyId(id,u);
           return new ResponseEntity<>(uid,HttpStatus.OK);
        
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<Boolean> deleteUser(@PathVariable Long id){
            Boolean uname=uSer.deleteUser(id);
            if(!uname){
                   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(uname,HttpStatus.OK);
        }
        @GetMapping("/role/{role}")
        public ResponseEntity<?> getUbyRole(@PathVariable String role){
            List<User> urole=uSer.getUbyRole(role);
            if(urole.isEmpty()){
                return new ResponseEntity<>("No users found with role: " + role,HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(urole,HttpStatus.OK);
        }
    
        @GetMapping("/username/{username}/role/{role}")
        public ResponseEntity<List<User>> getUbyUserNameandRole(@PathVariable String username,@PathVariable String role){
            List<User> urole=uSer.getUbyUserNameandRole(username,role);
            return new ResponseEntity<>(urole,HttpStatus.OK);
        }
    
    }


    

